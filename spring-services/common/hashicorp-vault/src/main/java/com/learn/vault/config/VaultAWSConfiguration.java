package com.learn.vault.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.vault.core.lease.SecretLeaseContainer;
import org.springframework.vault.core.lease.event.SecretLeaseCreatedEvent;

/**
 * Configuration for Vault AWS secret backend for STS
 *
 * @author Dhirendra Singh
 *
 */
@Configuration
@ConditionalOnProperty(name="spring.cloud.vault.aws.enabled")
@ConditionalOnBean(SecretLeaseContainer.class)
public class VaultAWSConfiguration implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(VaultAWSConfiguration.class);

    private static final String STS_PATH = "/sts/";

    ApplicationContext context;

    @Autowired
    SecretLeaseContainer container;

    @Autowired ConfigurableEnvironment configurableEnvironment;

    @Autowired ConfigurationPropertiesRebinder rebinder;

    @Value("${spring.cloud.vault.aws.backend}")
    String vaultAwsBackend;

    @Value("${spring.cloud.vault.aws.role}")
    String vaultAwsRole;

    @PostConstruct
    private void postConstruct() {
        logger.info("Register lease listener");

        container.addLeaseListener(leaseEvent -> {

            if (leaseEvent.getSource().getPath().contains(vaultAwsBackend + STS_PATH + vaultAwsRole)
                    && leaseEvent instanceof SecretLeaseCreatedEvent) {

                // rebind aws configuration for this app
                rebind("awsConfigurationProperties");

                // refresh additional bean dependencies as needed
                refresh("AWSConfiguration");
                refresh("basicAWSCredentials");
                refresh("amazonS3Client");

                logger.info("SecretLeaseCreatedEvent received and applied for: "+leaseEvent.getSource().getPath());
            }
        });

    }

    private void rebind(String bean) {
        try {
            boolean success = this.rebinder.rebind(bean);
            if (logger.isInfoEnabled()) {
                logger.info(String.format(
                        "Attempted to rebind bean '%s' with updated AWS secrets from vault, success: %s",
                        bean, success));
            }
        }
        catch (Exception ex) {
            logger.error("Exception rebinding "+bean,ex);
        }
    }

    private void refresh(String bean) {
        try {
            boolean success = this.context.getBean(RefreshScope.class).refresh(bean);
            if (logger.isInfoEnabled()) {
                logger.info(String.format(
                        "Attempted to refresh bean '%s' with updated AWS secrets from vault, success: %s",
                        bean, success));
            }
        }
        catch (Exception ex) {
            logger.error("Exception rebinding "+bean,ex);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}