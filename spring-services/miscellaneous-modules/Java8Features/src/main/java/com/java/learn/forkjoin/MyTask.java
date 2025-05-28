package com.java.learn.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Long> {

    private long workload;
    public MyTask(long workload){
        this.workload = workload;
    }
    @Override
    protected Long compute() {

        if(workload > 10){
            System.out.println("Splitting workload: "+this.workload);
            long workload1 = this.workload /2;
            long workload2 = this.workload - workload1;

            MyTask myTask1 = new MyTask(workload1);
            MyTask myTask2 = new MyTask(workload2);

            myTask1.fork();
            myTask2.fork();

            long result = 0;
            result += myTask1.join();
            result += myTask2.join();
            return result;

        }else{
            System.out.println("Doing it by myself workload: "+this.workload);
            return workload * 3;
        }
    }
}
