package com.java.learn.singleton;

public class DoubleCheckedLockSingleton {
    private static DoubleCheckedLockSingleton INSTANCE;
    private DoubleCheckedLockSingleton(){}

    public static DoubleCheckedLockSingleton getInstance(){
        if(INSTANCE == null){ // First Check
            synchronized (DoubleCheckedLockSingleton.class){
                if(INSTANCE == null){ // Second Check
                    INSTANCE = new DoubleCheckedLockSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
