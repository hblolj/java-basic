package com.hblolj.thread;

/**
 * Create With hblolj.
 * Data : 2019/2/21
 * Time : 10:10
 */
public class SyncBlockAndMethod {

    public void syncsTask(){
        synchronized (this){
            System.out.println("Hello");
        }
    }

    public synchronized void syncTask(){
        System.out.println("Hello Again");
    }
}
