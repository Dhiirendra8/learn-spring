package com.learn.vault.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * AWS configuration class to initialize aws client sdk.
 *
 * @author iyerk
 *
 */
@Configuration
@ConditionalOnProperty(name="spring.cloud.vault.aws.enabled")
@RefreshScope
public class AWSConfiguration {

    @Autowired
    AwsConfigurationProperties awsConfigurationProperties;

    @Value("${cloud.aws.region}")
    private String region;

    @Bean
    @RefreshScope
    public AWSSessionCredentials basicAWSCredentials() {
        AWSSessionCredentials credentials = new BasicSessionCredentials(awsConfigurationProperties.getAccesskey(),
                awsConfigurationProperties.getSecretKey(), awsConfigurationProperties.getSessionToken());
        return credentials;

    }

    @Bean
    @RefreshScope
    public AmazonS3 amazonS3Client(AWSCredentials awsCredentials) {

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
        return s3client;
    }

}
