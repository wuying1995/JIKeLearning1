package com.example.demo.case2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author wuhuimin
 * @Date 2022/5/10 6:02 下午
 * @Version 1.0
 */

@Slf4j
public class Case1Controller {

    volatile int a = 1;
    volatile int b = 1;

    public void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }

    public static void main(String[] args) {

        Case1Controller interesting = new Case1Controller();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}
