/**
 * 
 */
package com.pattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fajars
 * @version 1.0, Nov 6, 2019
 * @since
 */
public class CreditCardStrategy implements PaymentMethodStrategy {
    Logger log = LoggerFactory.getLogger(CreditCardStrategy.class);

    @Override
    public void pay(int amount) {
        log.info("{} paid using Credit Card.", amount);

    }

}
