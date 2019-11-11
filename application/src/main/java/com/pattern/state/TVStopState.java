package com.pattern.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TVStopState implements State {

    private static final Logger log = LoggerFactory
            .getLogger(TVStopState.class);

    @Override
    public void doAction() {
        log.info("TV is turned OFF");
    }

}