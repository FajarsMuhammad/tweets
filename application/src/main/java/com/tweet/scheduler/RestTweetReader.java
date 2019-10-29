package com.tweet.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tweet.model.ModelTweet;
import com.tweet.model.Tweet;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
public class RestTweetReader implements ItemReader<Tweet> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(RestTweetReader.class);

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextTweetIndex;
    private List<Tweet> tweets;

    RestTweetReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextTweetIndex = 0;
    }

    @Override
    public Tweet read() throws Exception {
        LOGGER.info("Reading the information of the next tweet");

        if (tweets == null) {
            tweets = fetchTweetFromAPI();
        }

        Tweet nextTweet = null;

        if (nextTweetIndex < tweets.size()) {
            nextTweet = tweets.get(nextTweetIndex);
            nextTweetIndex++;
        }

        LOGGER.info("Found tweet: {}", nextTweet);
        return nextTweet;
    }

    private List<Tweet> fetchTweetFromAPI() {
        LOGGER.debug(
                "Fetching tweet data from an external API by using the url: {}",
                apiUrl);

        ResponseEntity<ModelTweet[]> response = restTemplate
                .getForEntity(apiUrl, ModelTweet[].class);
       
        ModelTweet[] modelTweet = response.getBody();
        
        LOGGER.debug("Found {} tweets", modelTweet.length);
      
        return Arrays.stream(modelTweet).map(m -> {
            Tweet tweet = new Tweet();
            tweet.setUser(m.user().id());
            tweet.setMessage(m.text());
            return tweet;
        }).collect(Collectors.toList());
    }
}