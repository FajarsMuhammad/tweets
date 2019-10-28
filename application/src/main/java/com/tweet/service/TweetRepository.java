/**
 * 
 */
package com.tweet.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.model.Tweet;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
public interface TweetRepository extends JpaRepository<Tweet, String>{

}
