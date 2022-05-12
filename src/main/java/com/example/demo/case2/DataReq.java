package com.example.demo.case2;


/**
 * @Author wuhuimin
 * @Date 2022/5/10 4:26 下午
 * @Version 1.0
 */
public class DataReq {
    private static int counter = 0;

    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        DataReq.counter = counter;
    }
}