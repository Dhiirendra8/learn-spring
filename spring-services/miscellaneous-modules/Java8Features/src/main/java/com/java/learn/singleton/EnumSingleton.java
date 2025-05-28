package com.java.learn.singleton;

public enum EnumSingleton {
    INSTANCE;

    public void doSomething(){
        System.out.println("Doing Something");
    }

    public static void main(String[] args) {
        EnumSingleton obj = EnumSingleton.INSTANCE;
        obj.doSomething();
    }

}
