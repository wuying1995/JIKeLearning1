package com.example.demo.case6;

/**
 * @Author wuhuimin
 * @Date 2022/5/12 10:37 上午
 * @Version 1.0
 */
@Entity
@Datapublic
class UserEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }
}