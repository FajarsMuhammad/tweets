/**
 * 
 */
package com.tweet.service;

import java.util.List;

import com.tweet.model.Tweet;
import com.tweet.model.TweetSearchParams;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
public interface TweetService {

    List<Tweet> saveTweets(List<Tweet> tweets);

    List<Tweet> fetchTweets(TweetSearchParams searchParams);

}
