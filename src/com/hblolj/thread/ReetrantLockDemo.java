package com.hblolj.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/21
 * Time : 11:23
 */
public class ReetrantLockDemo implements Runnable{

    private static ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReetrantLockDemo demo = new ReetrantLockDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
    }
}
