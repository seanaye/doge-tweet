package com.graphqljava.dogetweet.doge;

import org.springframework.stereotype.Component;
import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.signature.TwitterCredentials;

@Component
public class TweetClient {
	private static TwitterClient client;

	public TweetClient() {
		String accessToken = System.getProperty("accessToken");
		String accessTokenSecret = System.getProperty("accessTokenSecret");
		String apiKey = System.getProperty("apiKey");
		String apiSecret = System.getProperty("apiSecret");

		System.out.println(apiSecret);
		System.out.println(apiKey);

		this.client = new TwitterClient(TwitterCredentials.builder()
				.accessToken(accessToken)
				.accessTokenSecret(accessTokenSecret)
				.apiKey(apiKey)
				.apiSecretKey(apiSecret)
				.build());
	}

	public TwitterClient getClient() {
		return client;
	}
}
