package com.hblolj.thread;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 11:26
 */
public class RunnableDemo {

    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable("r1");
        MyRunnable r2 = new MyRunnable("r2");
        MyRunnable r3 = new MyRunnable("r3");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();
    }
}
