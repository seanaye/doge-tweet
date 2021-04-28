package com.graphqljava.dogetweet.doge;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import com.graphqljava.dogetweet.doge.TweetClient;


@Component
public class GraphQLDataFetchers {
	private static TweetClient client = new TweetClient();

	public DataFetcher getLatestTweetsFetcher() {
		return dataFetchingEnvironment -> {
			return client.getClient().searchForTweetsWithin7days("@elonmusk doge");
		};
	}

}
