package com.hblolj.reflect;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/18
 * Time : 15:05
 */
public class Robot {

    private String name;

    public void sayHi(String s){
        System.out.println(s + " " + name);
    }

    private String throwHello(String tag){
        return "Hello " + tag;
    }

    static {
        System.out.println("The Static Code In The Robot");
    }
}
