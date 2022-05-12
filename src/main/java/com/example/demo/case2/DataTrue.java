package com.example.demo.case2;

/**
 * @Author wuhuimin
 * @Date 2022/5/10 4:43 下午
 * @Version 1.0
 */

public class DataTrue {

    private static int counter = 0;
    private static Object locker = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }
    public void right() {
        synchronized (locker) {
            counter++;
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        DataTrue.counter = counter;
    }
}
