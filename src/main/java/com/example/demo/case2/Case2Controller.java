package com.example.demo.case2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * @Author wuhuimin
 * @Date 2022/5/10 4:27 下午
 * @Version 1.0
 */
@RestController
public class Case2Controller {


    @GetMapping("wrong/v2")
    public int wrong(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        DataReq.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new DataReq().wrong());
        return DataReq.getCounter();
    }

    @GetMapping("right/v2")
    public int right(@RequestParam(value = "count", defaultValue = "1000000") int count) {
        DataTrue.reset();
        //多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new DataTrue().right());
        return DataTrue.getCounter();
    }



}
