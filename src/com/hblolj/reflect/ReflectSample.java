package com.hblolj.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/18
 * Time : 15:06
 */
public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            InvocationTargetException, NoSuchMethodException, NoSuchFieldException {

        System.out.println(System.getProperty("java.ext.dirs"));

        Class<?> clazz = Class.forName(Robot.class.getName());

        Robot r = (Robot) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "moos");

        // 可以获取该类的所有方法，但是该类继承或实现的接口方法除外
        Method getHello = clazz.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);

        String result = (String) getHello.invoke(r, "tag");
        System.out.println(result);

        // 可以获取该类的所有 public 方法，包括该类继承和实现的接口方法
        Method sayHi = clazz.getMethod("sayHi", String.class);
        sayHi.invoke(r, "Welcome");
    }
}
