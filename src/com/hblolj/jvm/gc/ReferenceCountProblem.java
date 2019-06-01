package com.hblolj.jvm.gc;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/19
 * Time : 13:57
 */
public class ReferenceCountProblem {

    public static void main(String[] args) {

        MyObject o1 = new MyObject();
        MyObject o2 = new MyObject();

        o1.setChildNode(o2);
        o2.setChildNode(o1);
    }
}
