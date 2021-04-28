@Component
public class TweetClient {
	private static TwitterClient client;

	public TweetClient() {
		String accessToken = System.getenv("access_token");
		String accessTokenSecret = System.getenv("access_token_secret");
		String apiKey = System.getenv("api_key");
		String apiKeySecret = System.getenv("api_key_secret");

		this.client = new TwitterClient(TwitterCredentials.builder()
				.accessToken(acessToken)
				.accessTokenSecret(accessTokenSecret)
				.apiKey(apiKey)
				.apiSecretKey(apiKeySecret)
				.build());
	}

	public TwitterClient getClient() {
		return client
	}
}
