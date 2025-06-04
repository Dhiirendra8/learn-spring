package com.java.learn.threads.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class Task implements Callable<String>{
    CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public String call() throws Exception {
        try{
            Thread.sleep(1000);
        }finally {
            countDownLatch.countDown();
        }
        return Thread.currentThread().getName()+" runs successfully";
    }
}
public class CountDownLatchExample {


    public static void main(String[] args) {
        Thread t1 = new Thread();
    }
}
