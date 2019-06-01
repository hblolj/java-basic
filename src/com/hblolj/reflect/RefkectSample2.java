package com.hblolj.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create With hblolj.
 * Data : 2019/3/4
 * Time : 16:10
 */
public class RefkectSample2 {

    public static void main(String[] args){

        try {
            Class<?> claszz = Class.forName(Robot.class.getName());
            Object o = claszz.newInstance();

            Field name = claszz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(o, "Kun");

            Method sayHi = claszz.getDeclaredMethod("sayHi", String.class);
            sayHi.invoke(o, "Zard");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
