/**
 * 
 */
package com.tweet.service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tweet.model.Tweet;
import com.tweet.model.TweetSearchParams;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
@RunWith(SpringRunner.class)
public class TweetControllerTest {

    static final String DUMMY_UUID = "50f26e57-f7b2-11e8-9a3e-34689524a2a7";

    private MockMvc mockMvc;

    @Mock
    private TweetService tweetService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new TweetController(tweetService))
                .build();
    }

    @Test
    void testFetchTweetController() throws Exception {
        TweetSearchParams searchParams = new TweetSearchParams();
        searchParams.setPeriod("30Day");

        when(tweetService.fetchTweets(searchParams))
                .thenReturn(Arrays.asList(dummyTweet()));

        mockMvc.perform(post("/tweets?period=" + searchParams.getPeriod())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    Tweet dummyTweet() {
        Tweet tweet = new Tweet();
        tweet.setUuid(DUMMY_UUID);
        tweet.setUser("1234");
        tweet.setMessage("My First Tweet");
        return tweet;
    }
}
