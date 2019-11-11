package com.pattern.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserImpl extends User {

    private static final Logger log = LoggerFactory.getLogger(UserImpl.class);

    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        log.info("{}: Sending Message = {}", this.name, msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        log.info("{} : Received Message: {}", this.name, msg);
    }

}