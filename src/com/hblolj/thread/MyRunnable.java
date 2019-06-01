package com.hblolj.thread;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 11:25
 */
public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("Thread start: " + name + ", i=" + i);
        }
    }
}
