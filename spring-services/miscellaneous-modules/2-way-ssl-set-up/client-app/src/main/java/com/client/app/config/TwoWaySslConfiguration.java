package com.client.app.config;

import lombok.SneakyThrows;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


import java.io.BufferedInputStream;
import java.security.KeyStore;

@Configuration
public class TwoWaySslConfiguration {
    @Value("classpath:keystore.jks")
    private Resource keyStoreData;

    @Value("${keystore-pwd}")
    private String keyStorePassword;

    @Value("${key-pwd}")
    private String keyPassword;

    @Bean
    @SneakyThrows
    public RestTemplate restTemplate() {
        KeyStore keyStore = KeyStore.getInstance("jks");
        keyStore.load(new BufferedInputStream(keyStoreData.getInputStream()), keyStorePassword.toCharArray());

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
                new SSLContextBuilder()
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .loadKeyMaterial(keyStore, keyPassword.toCharArray()).build()
                , NoopHostnameVerifier.INSTANCE);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .setMaxConnTotal(1)
                .setMaxConnPerRoute(5)
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        requestFactory.setReadTimeout(10000);
        requestFactory.setConnectionRequestTimeout(10000);

        return new RestTemplate(requestFactory);
    }
}
