package com.hblolj.thread;

/**
 * Create With hblolj.
 * Data : 2019/3/1
 * Time : 16:59
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){

        @Override
        protected Object initialValue() {
            System.out.println(Thread.currentThread().getName() + " 调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args) {

        new Thread(new MyIntegerTask("IntegerTask1")).start();
        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable{

        private String name;

        public MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : " + name);
            for (int i = 0; i < 5; i++) {
                if (null == ThreadLocalDemo.threadLocal.get()){
                    ThreadLocalDemo.threadLocal.set(0);
                    System.out.println(Thread.currentThread().getName() + ": 0");
                }else {
                    Integer num = (Integer) ThreadLocalDemo.threadLocal.get();
                    ThreadLocalDemo.threadLocal.set(num + 1);
                    System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalDemo.threadLocal.get());
                    if (i == 3){
                        ThreadLocalDemo.threadLocal.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyStringTask implements Runnable{

        private String name;

        public MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : " + name);
            for (int i = 0; i < 5; i++) {
                if (null == ThreadLocalDemo.threadLocal.get()){
                    ThreadLocalDemo.threadLocal.set("a");
                    System.out.println(Thread.currentThread().getName() + ": a");
                }else {
                    String str = (String) ThreadLocalDemo.threadLocal.get();
                    ThreadLocalDemo.threadLocal.set(str + "a");
                    System.out.println(Thread.currentThread().getName() + ThreadLocalDemo.threadLocal.get());
                    if (i == 3){
                        ThreadLocalDemo.threadLocal.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
