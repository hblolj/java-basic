package com.hblolj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/25
 * Time : 11:24
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        // 最多只能 5 个线程同时访问
        Semaphore semp = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);
//                    Thread.sleep((long) (Math.random() * 10000));
                    Thread.sleep(1000);
                    // 访问完后，释放
                    semp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }

        exec.shutdown();
    }
}
