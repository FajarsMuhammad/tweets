package com.pattern.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractPatternDriver {

    private static final Logger log = LoggerFactory
            .getLogger(AbstractPatternDriver.class);

    public static void main(String[] args) {
        AbstractFactory<?> abstractFactory;

        // creating a brown toy dog
        abstractFactory = FactoryProvider.getFactory("Toy");
        Animal toy = (Animal) abstractFactory.create("Dog");

        abstractFactory = FactoryProvider.getFactory("Color");
        Color color = (Color) abstractFactory.create("Brown");

        String result = "A " + toy.getType() + " with " + color.getColor()
                + " color " + toy.makeSound();

        log.info(result);
    }
}