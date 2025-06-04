package com.java.learn.threads.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class MainClass {
    public static void main(String[] args) {
        MyTask myTask = new MyTask(40);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        long result = forkJoinPool.invoke(myTask);
        System.out.println("Result: "+result);
    }
}
