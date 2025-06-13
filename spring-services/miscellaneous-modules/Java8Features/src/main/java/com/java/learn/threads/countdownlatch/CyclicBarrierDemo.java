package com.java.learn.threads.countdownlatch;

import org.apache.tomcat.util.net.Acceptor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int NUM_TASK = 5;
    private static final int NUM_THREAD = 3;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_TASK, ()-> System.out.println("Cyclic Barrier reaches ..."));
    public static void main(String[] args) {
        for (int i = 0; i < NUM_TASK; i++) {

            Thread t = new Thread(new Actors(cyclicBarrier));
            t.start();
            System.out.println("Starting starts "+i);
        }
    }

    static class Actors implements Runnable {
        private CyclicBarrier cyclicBarrier;

        Actors(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            for (int i = 0; i <NUM_THREAD ; i++) {
                try{
                    Thread.sleep(1000);
                    System.out.println("Thread "+Thread.currentThread().getName()+" waiting "+ i);
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    Thread.currentThread().interrupt();
                }
            }


        }
    }
}
