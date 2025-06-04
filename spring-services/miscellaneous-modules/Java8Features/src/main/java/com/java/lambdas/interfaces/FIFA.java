package com.java.lambdas.interfaces;

@FunctionalInterface
public interface FIFA {

    default String defaultMethod(String str){
        return str;
    }
    public String method();
}
