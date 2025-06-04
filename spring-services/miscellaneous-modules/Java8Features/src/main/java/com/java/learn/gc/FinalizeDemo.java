package com.java.learn.gc;

public class FinalizeDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called for object");
    }

    public static void main(String[] args) {
        FinalizeDemo obj = new FinalizeDemo();
        obj = null;

        System.gc(); // Request GC (may or may not trigger finalize immediately)
        System.out.println("Main method ends");
    }
}
