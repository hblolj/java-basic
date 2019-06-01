package com.hblolj.thread;

import java.util.concurrent.Callable;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 13:41
 */
public class MyCallable implements Callable<String>{


    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("Task done");
        return value;
    }
}
