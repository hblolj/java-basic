package com.hblolj.jvm.gc;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/19
 * Time : 13:56
 */
public class MyObject {

    private MyObject childNode;

    public MyObject getChildNode() {
        return childNode;
    }

    public void setChildNode(MyObject childNode) {
        this.childNode = childNode;
    }
}
