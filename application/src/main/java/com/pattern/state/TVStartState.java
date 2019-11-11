package com.pattern.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVStartState implements State {
    
    private static final Logger log = LoggerFactory
            .getLogger(TVStartState.class);

    @Override
    public void doAction() {
        log.info("TV is turned ON");
    }

}