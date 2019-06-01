package com.hblolj.reflect;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/18
 * Time : 16:59
 */
public class LoadDifference {

    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader classLoader = Robot.class.getClassLoader();
//        Class<?> clazz = classLoader.loadClass(Robot.class.getName());

        Class<?> clazz = Class.forName(Robot.class.getName());
    }
}
