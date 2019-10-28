/**
 *
 */
package com.tweet.model;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
public class TweetSearchParams {

    private String message;
    private String period;

    public String getMessage() {
        return message;
    }

    public String getPeriod() {
        return period;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
