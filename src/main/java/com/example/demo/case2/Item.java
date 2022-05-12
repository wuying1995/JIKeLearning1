package com.example.demo.case2;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wuhuimin
 * @Date 2022/5/10 5:50 下午
 * @Version 1.0
 */

@Data
@RequiredArgsConstructor
public class Item {
    final String name; //商品名
    int remaining = 1000; //库存剩余

    @ToString.Exclude //ToString不包含这个字段
    ReentrantLock lock = new ReentrantLock();
}
