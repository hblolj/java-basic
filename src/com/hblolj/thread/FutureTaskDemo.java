package com.hblolj.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/20
 * Time : 13:42
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread t = new Thread(task);
        t.start();
        if (!task.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        // 阻塞
        System.out.println("task return: " + task.get());
        System.out.println("Hello World!");
    }
}
