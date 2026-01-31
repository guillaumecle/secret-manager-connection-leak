import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;

public class SecretManagerConnectionLeak{

	public static void main(String[] args){
		try(SecretsManagerClient client = SecretsManagerClient.builder().build()){
			GetSecretValueRequest request = GetSecretValueRequest.builder().secretId(args[0]).build();
			try{
				client.getSecretValue(request);
			}catch(RuntimeException e){
				System.out.println(e.toString());
			}
		}
	}
}
