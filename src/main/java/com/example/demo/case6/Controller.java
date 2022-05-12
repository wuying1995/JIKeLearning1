package com.example.demo.case6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wuhuimin
 * @Date 2022/5/12 10:41 上午
 * @Version 1.0
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    private UserService userService;


    @GetMapping("wrong1")
    public int wrong1(@RequestParam("name") String name) {
        return userService.createUserWrong1(name);
    }

    @GetMapping("right2")
    public int right2(@RequestParam("name") String name) {
        try {
            userService.createUserPublic(new UserEntity(name));
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
        return userService.getUserCount(name);
    }

}
