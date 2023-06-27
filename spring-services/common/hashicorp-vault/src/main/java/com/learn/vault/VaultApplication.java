package com.learn.vault;

import com.learn.vault.config.AWSConfiguration;
import com.learn.vault.config.AwsConfigurationProperties;
import com.learn.vault.config.VaultConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.cloud.vault.config.aws.VaultAwsProperties;

@SpringBootApplication
public class VaultApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(VaultApplication.class, args);
//        VaultConfig vaultconfig = context.getBean(VaultConfig.class);
//        System.out.println("Username: " + vaultconfig.getUsername());
//        System.out.println("Password: " + vaultconfig.getPassword());

        AwsConfigurationProperties awsvaultconfig = context.getBean(AwsConfigurationProperties.class);
        System.out.println("Access Key: " + awsvaultconfig.getAccesskey());
        System.out.println("Secret Key: " + awsvaultconfig.getSecretKey());
        System.out.println("Session Token: " + awsvaultconfig.getSessionToken());
        System.out.println("Prop : "+ awsvaultconfig);

    }

}
