package com.hblolj.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Create With hblolj
 * Data : 2019/2/25
 * Time : 11:08
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Task(countDownLatch), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread3").start();
        boolean b = countDownLatch.await(30, TimeUnit.SECONDS);
        System.out.println(b);
        System.out.println("所有线程已到达，主线程开始执行" + System.currentTimeMillis());
    }

    class Task implements Runnable{

        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            countDownLatch.countDown();
        }
    }
}
