package com.learn.vault.secrets;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretRequest;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

/**
 * Before running this Java V2 code example, set up your development environment, including your credentials.
 *
 * For more information, see the following documentation topic:
 *
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
public class CreateSecret {

    public static void main(String[] args) {

        final String usage = "\n" +
                "Usage:\n" +
                "    <secretName> <secretValue> \n\n" +
                "Where:\n" +
                "    secretName - The name of the secret (for example, tutorials/MyFirstSecret). \n"+
                "    secretValue - The secret value. \n";

        if (args.length != 2) {
            System.out.println(usage);
            System.exit(1);
        }

        String secretName = args[0];
        String secretValue= args[1];
        Region region = Region.US_EAST_1;
        SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        String secretARN = createNewSecret(secretsClient, secretName, secretValue);
        System.out.println("The secret ARN is "+ secretARN);
        secretsClient.close();
    }

    public static String createNewSecret( SecretsManagerClient secretsClient, String secretName, String secretValue) {

        try {
            CreateSecretRequest secretRequest = CreateSecretRequest.builder()
                    .name(secretName)
                    .description("This secret was created by the AWS Secret Manager Java API")
                    .secretString(secretValue)
                    .build();

            CreateSecretResponse secretResponse = secretsClient.createSecret(secretRequest);
            return secretResponse.arn();

        } catch (SecretsManagerException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }
}

