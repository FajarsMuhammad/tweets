/**
 * 
 */
package com.tweet.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.tweet.model.ModelTweet;
import com.tweet.model.Tweet;
import com.tweet.model.TweetSearchParams;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    private final RestTemplate restTemplate;

    public TweetServiceImpl(TweetRepository tweetRepository,
            RestTemplate restTemplate) {
        this.tweetRepository = tweetRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Tweet> fetchTweets(TweetSearchParams searchParams) {
        final ModelTweet[] modelTweets = restTemplate.getForObject(
                "https://api.twitter.com/1.1/tweets/search/"
                        + searchParams.getPeriod() + " /my_env_name.json",
                ModelTweet[].class);
       
        return Arrays.stream(modelTweets).map(m -> {
            Tweet tweet = new Tweet();
            tweet.setUser(m.user().id());
            tweet.setMessage(m.text());
            return tweet;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Tweet> saveTweets(List<Tweet> tweets) {
        return tweetRepository.saveAll(tweets);
    }
    
    @Override
    @Transactional
    public Tweet saveTweet(Tweet tweets) {
        return tweetRepository.save(tweets);
    }
}
