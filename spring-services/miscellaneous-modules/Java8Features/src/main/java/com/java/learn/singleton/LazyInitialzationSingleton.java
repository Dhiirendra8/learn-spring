package com.java.learn.singleton;

public class LazyInitialzationSingleton {
    private static LazyInitialzationSingleton INSTANCE;
    private LazyInitialzationSingleton(){}

    public static LazyInitialzationSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyInitialzationSingleton();
        }
        return INSTANCE;
    }
}
