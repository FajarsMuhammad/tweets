package com.pattern.dependency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory
            .getLogger(EmailServiceImpl.class);

    @Override
    public void sendMessage(String msg, String rec) {
        // logic to send email
        log.info("Email sent to {} with Message= {}", rec, msg);
    }

}