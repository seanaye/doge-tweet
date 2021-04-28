package com.graphqljava.dogetweet.doge;

import java.io.File;
import com.google.common.io.Resources;
import com.google.common.base.Charsets;
import org.springframework.stereotype.Component;
import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.signature.TwitterCredentials;

import java.io.IOException;

@Component
public class TweetClient {
	private static TwitterClient client;

	public TweetClient() {
		try {
			String json = Resources.toString(Resources.getResource("apiKeys.json"), Charsets.UTF_8);
			this.client = new TwitterClient(TwitterClient.OBJECT_MAPPER
				.readValue(json, TwitterCredentials.class));
		} catch (IOException e) {
			System.out.println("CANT READ API KEYS FILE");
		}
	}


	public TwitterClient getClient() {
		return client;
	}
}
