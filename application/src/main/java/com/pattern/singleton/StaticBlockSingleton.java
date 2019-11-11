package com.pattern.singleton;

public class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    /** Don't let anyone else instantiate this class */
    private StaticBlockSingleton() {
    }

    /** Create the one-and-only instance in a static block */
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /** Provide a public method to get the instance that we created */
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}