package com.hblolj.thread;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 13:34
 */
public class CycleWait implements Runnable{

    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
//        while (cycleWait.value == null){
//            Thread.currentThread().sleep(100);
//        }
        t.join();
        System.out.println("value: " + cycleWait.value);
    }
}
