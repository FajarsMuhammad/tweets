package com.tweet.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.tweet.model.Tweet;
import com.tweet.service.TweetService;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
@Configuration
public class RestTweetJobConfig {

    private final TweetService tweetService;

    public RestTweetJobConfig(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Bean
    public Job restTweetJob(JobBuilderFactory jobBuilderFactory,
            @Qualifier("restTweetStep") Step restTweetStep) {
        return jobBuilderFactory.get("restTweetJob")
                .incrementer(new RunIdIncrementer())
                .flow(restTweetStep)
                .end()
                .build();
    }

    @Bean
    public ItemProcessor<Tweet, Tweet> restTweetProcessor() {
        return new TweetProcessor();
    }

    @Bean
    public ItemReader<Tweet> restTweetReader(Environment environment,
            RestTemplate restTemplate) {
        return new RestTweetReader(
                "https://api.twitter.com/1.1/tweets/search/30Day/tweets.json",
                restTemplate);
    }

    @Bean
    public Step restTweetStep(ItemReader<Tweet> restTweetReader,
            ItemProcessor<Tweet, Tweet> restTweetProcessor,
            ItemWriter<Tweet> restTweetWriter,
            StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("restTweetStep")
                .<Tweet, Tweet> chunk(1)
                .reader(restTweetReader)
                .processor(restTweetProcessor)
                .writer(restTweetWriter)
                .build();
    }

    @Bean
    public ItemWriter<Tweet> restTweetWriter() {
        return new TweetWriter(tweetService);
    }
}