package com.hblolj.thread;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 11:22
 */
public class MyThread extends Thread{

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("Thread start: " + name + ", i=" + i);
        }
    }
}
