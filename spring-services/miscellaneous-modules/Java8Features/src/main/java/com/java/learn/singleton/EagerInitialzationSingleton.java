package com.java.learn.singleton;

public class EagerInitialzationSingleton {

    private static final EagerInitialzationSingleton INSTANCE = new EagerInitialzationSingleton();
    private EagerInitialzationSingleton(){}

    public static EagerInitialzationSingleton getInstance(){
        return INSTANCE;
    }
}
