package com.java.learn.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    static Semaphore semaphore = new Semaphore(1); // allow 2 threads at a time

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " is trying to acquire...");
                    semaphore.acquire();
                    System.out.println("Thread " + threadId + " acquired permit!");
                    Thread.sleep(2000); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("Thread " + threadId + " released permit.");
                }
            }).start();
        }
    }
}