package com.example.demo.case2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author wuhuimin
 * @Date 2022/5/10 5:52 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class Case4Controller {

    @GetMapping("wrong/v4")
    public long wrong() {
        long begin = System.currentTimeMillis();
        //并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart();
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();
//        log.info("success:{} totalRemaining:{} took:{}ms items:{}", success,
//                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
//                System.currentTimeMillis() - begin, items);
        return success;
    }

    //解决方法1 为购物车中的商品排一下序，让所有的线程一定是先获取 item1 的锁然后获取 item2 的锁，就不会有问题了

//    @GetMapping("right")
//    public long right() {
//        //...
//        long success = IntStream.rangeClosed(1, 100).parallel().mapToObj(i -> {
//            List cart = (List) createCart().stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
//            return createOrder(cart);
//        }).filter(result -> result).count();
//        //...
//        return success;
//    }


    //每次从商品清单（items 字段）中随机选购三个商品（为了逻辑简单，我们不考虑每次选购多个同类商品的逻辑，购物车中不体现商品数量）：'
    private List createCart() {
//        return IntStream.rangeClosed(1, 3).mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt(item.size())).map(name -> items.get(name)).collect(Collectors.toList());
        return null;
    }


    private boolean createOrder(List<Item> order) {
        //存放所有获得的锁
        List<ReentrantLock> locks = new ArrayList<>();

        for (Item item : order) {
            try {
                //获得锁10秒超时
                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {
                    locks.add(item.lock);
                } else {
                    locks.forEach(ReentrantLock::unlock);
                    return false;
                }
            } catch (InterruptedException e) {
            }
        }
        //锁全部拿到之后执行扣减库存业务逻辑
        try {
            order.forEach(item -> item.remaining--);
        } finally {
            locks.forEach(ReentrantLock::unlock);
        }
        return true;
    }


}
