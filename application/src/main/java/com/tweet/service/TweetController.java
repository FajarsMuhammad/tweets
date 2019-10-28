/**
 * 
 */
package com.tweet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tweet.model.Tweet;
import com.tweet.model.TweetSearchParams;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
@Controller
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping(value = "/tweets",
            produces = { "application/json" })
    public ResponseEntity<List<String>> fetchTweet(
            @ModelAttribute TweetSearchParams searchParams) {

        List<Tweet> lists = tweetService.fetchTweets(searchParams);

        List<Tweet> fetchTweet = tweetService.saveTweets(lists);
        return new ResponseEntity<>(
                fetchTweet.stream().map(Tweet::getUuid)
                        .collect(Collectors.toList()),
                HttpStatus.CREATED);
    }

}
