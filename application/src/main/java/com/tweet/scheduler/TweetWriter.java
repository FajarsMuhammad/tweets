package com.tweet.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.tweet.model.Tweet;
import com.tweet.service.TweetService;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
public class TweetWriter implements ItemWriter<Tweet> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(TweetWriter.class);

    private final TweetService tweetService;

    public TweetWriter(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public void write(List<? extends Tweet> items) throws Exception {
        LOGGER.info("Received the information of {} tweets", items.size());

        items.stream().forEach(tweet -> {
            LOGGER.debug("Received the information of a tweet: {}", tweet);
            tweetService.saveTweet(tweet);
        });
    }
}