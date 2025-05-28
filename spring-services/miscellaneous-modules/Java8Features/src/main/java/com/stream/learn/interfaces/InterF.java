package com.stream.learn.interfaces;

public interface InterF {

    public void m1();

    default void defaultM1(){
        System.out.println("This is default method of interface InterF");
    }
    static void staticM1(){
        System.out.println("This is static method of interface InterF");
    }
}
