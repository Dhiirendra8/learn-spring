package com.learn.vault.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.learn.vault.config.AwsConfigurationProperties.PREFIX;

/**
 * Sample ConfigurationProperties for AWS STS
 *
 * @author Dhirendra Singh
 *
 */
@ConfigurationProperties(PREFIX)
@Component
public class AwsConfigurationProperties {

    /**
     * Prefix for configuration properties.
     */
    public static final String PREFIX = "cloud.aws.credentials";

    private String accessKey;

    private String secretKey;

    private String sessionToken;

    public String getAccesskey() {
        return accessKey;
    }

    public void setAccesskey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "AwsConfigurationProperties [accessKey=" + accessKey + ", secretKey=" + secretKey + ", sessionToken="
                + sessionToken + "]";
    }

}
