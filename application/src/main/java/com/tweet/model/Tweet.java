package com.tweet.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author fajars
 * @version 1.0, Oct 28, 2019
 * @since
 */
@Entity
@Table(name = "tweets")
@SuppressWarnings("serial")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @Column(name = "user")
    private String user;

    @Column(name = "message")
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
