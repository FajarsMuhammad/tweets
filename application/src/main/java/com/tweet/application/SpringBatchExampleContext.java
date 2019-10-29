package com.tweet.application;

import javax.persistence.PersistenceContext;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
@Configuration
@ComponentScan
@EnableBatchProcessing
@EnableScheduling
@Import({ PersistenceContext.class })
@PropertySource("classpath:application.yaml")
public class SpringBatchExampleContext {

    @Bean
    PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}