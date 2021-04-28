package com.graphqljava.dogetweet.doge;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import com.github.redouane59.twitter.dto.tweet.Tweet;

import com.graphqljava.dogetweet.doge.TweetClient;


@Component
public class GraphQLDataFetchers {
	private static TweetClient client = new TweetClient();

	public DataFetcher getLatestTweetsFetcher() {
		return dataFetchingEnvironment -> {
			return client.getClient().searchForTweetsWithin7days("@elonmusk doge", 10, null).getTweets();
		};
	}
	public DataFetcher getUserByIdFetcher() {
		return dataFetchingEnvironment -> {
			Tweet tweet = dataFetchingEnvironment.getSource();
			return client.getClient().getUserFromUserId(tweet.getAuthorId());
		};
	}

}
