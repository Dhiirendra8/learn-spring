package com.java.learn.threads.deadlock;

class Pen{

    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is using Pen "+this+ " and trying to use Paper "+paper );
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finishing writing with Pen "+this);
    }

}
class Paper{
    public synchronized void writeWithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using Paper "+this+ " and trying to use Pen "+pen );
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finishing writing with Paper "+this);
    }
}

class Task1 implements Runnable{
    private final Pen pen;
    private final Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}
class Task2 implements Runnable{
    private final Pen pen;
    private final Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        synchronized (pen){
            paper.writeWithPenAndPaper(pen);
        }

    }
}
public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Task1 task1 = new Task1(pen,paper);
        Task2 task2 = new Task2(pen,paper);

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();
    }
}
