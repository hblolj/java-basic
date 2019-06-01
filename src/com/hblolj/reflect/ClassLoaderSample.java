package com.hblolj.reflect;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/18
 * Time : 15:51
 */
public class ClassLoaderSample {

    public static void main(String[] args) {

        MyClassLoader loader = new MyClassLoader("G://", "myClassLoader");
        try {
            Class<?> c = loader.findClass("Wali");
            System.out.println(c.getClassLoader());
            c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
