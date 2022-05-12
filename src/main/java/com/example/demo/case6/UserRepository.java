package com.example.demo.case6;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wuhuimin
 * @Date 2022/5/12 10:37 上午
 * @Version 1.0
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);
}