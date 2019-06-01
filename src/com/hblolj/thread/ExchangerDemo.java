package com.hblolj.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create With hblolj
 * Data : 2019/2/25
 * Time : 11:31
 */
public class ExchangerDemo {

    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        // 代表男生和女生
        ExecutorService exe = Executors.newFixedThreadPool(2);

        exe.execute(() -> {
            try {
                // 1 号对 3 号说
                String one = exchanger.exchange("你好，我是 1 号!");
                System.out.println("1 号说: " + one);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        exe.execute(() -> {
            try {
                System.out.println("1 号出场!");
                TimeUnit.SECONDS.sleep(3);
                // 3 号对 1号说
                String three = exchanger.exchange("你好，我是 3 号!");
                System.out.println("3 号说: " + three);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
