package com.hblolj.thread;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 11:13
 */
public class ThreadTest {

    private static void attck(){
        System.out.println("1");
        System.out.println("Curren Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                attck();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        attck();
                    }
                }).run();
            }
        };

        System.out.println("Curren Main Thread: " + Thread.currentThread().getName());

        t.start();
    }
}
