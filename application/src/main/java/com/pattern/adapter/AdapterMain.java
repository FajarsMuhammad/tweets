package com.pattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterMain {

    private static final Logger log = LoggerFactory
            .getLogger(AdapterMain.class);

    public static void main(String[] args) {
        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(
                bugattiVeyron);

        log.info("{}", bugattiVeyronAdapter.getSpeed());
    }
}