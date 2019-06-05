package com.hblolj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Create With hblolj.
 * Data : 2019/6/1
 * Time : 12:37
 */
public class SimpleDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        // TODO: 2019/6/5 时间 pattern 格式详解
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        new Thread(() -> {
            try {
                System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " 休眠2秒，再尝试获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " 尝试获取锁");
            synchronized (SimpleDemo.class){
                System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " 获取到了锁");
                SimpleDemo.class.notify();
                System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " notify");
            }
        }, "线程一").start();

        new Thread(() -> {
            synchronized (SimpleDemo.class){

                System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " 获取到了锁");
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + " 阻塞，让出锁，同时让出当前线程对 cpu 的使用");
                    SimpleDemo.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(df.format(new Date()) + " -> " + Thread.currentThread().getName() + "after wait()");
                countDownLatch.countDown();
            }
        }, "线程二").start();

        countDownLatch.await();
    }
}
