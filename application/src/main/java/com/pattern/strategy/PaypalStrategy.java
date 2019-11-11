package com.pattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaypalStrategy implements PaymentMethodStrategy {
    Logger log = LoggerFactory.getLogger(PaypalStrategy.class);

    @Override
    public void pay(int amount) {
        log.info("{} paid using Paypal.", amount);
    }

}