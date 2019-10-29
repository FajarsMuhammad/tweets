package com.tweet.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.tweet.model.Tweet;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
public class TweetProcessor implements ItemProcessor<Tweet, Tweet> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetProcessor.class);

    @Override
    public Tweet process(Tweet item) throws Exception {
        LOGGER.info("Processing tweet information: {}", item);
        return item;
    }
}