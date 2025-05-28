package com.java.learn.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton INSTANCE;

//    public static Integer abc = null;
    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ThreadSafeSingleton();
        }
        return INSTANCE;
    }

//    public static void main(String[] args) {
//        Integer xyz = ThreadSafeSingleton.abc;
//        System.out.println(xyz);
//    }
}
