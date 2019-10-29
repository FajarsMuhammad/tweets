package com.tweet.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fajars
 * @version 1.0, Oct 29, 2019
 * @since
 */
@SpringBootApplication
@ComponentScan({ "com.tweet" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
