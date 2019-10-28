/**
 * 
 */
package com.tweet.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.tweet.model.Tweet;
import com.tweet.service.TweetRepository;
import com.tweet.service.TweetService;
import com.tweet.service.TweetServiceImpl;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
public class TweetServiceTest {
    private TweetService tweetService;

    @Mock
    private TweetRepository tweetRepository;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        this.tweetService = new TweetServiceImpl(tweetRepository, restTemplate);
    }

    @Test
    void fetchTweetTest() {

        Tweet tweet = new Tweet();
        tweet.setUuid(UUID.randomUUID().toString());
        tweet.setUser("12345");
        tweet.setMessage("My First Tweet");
        when(tweetRepository.saveAll(any())).thenReturn(Arrays.asList(tweet));
        tweetService.saveTweets(Arrays.asList(tweet));
        verify(tweetRepository).saveAll(any());

    }

}
