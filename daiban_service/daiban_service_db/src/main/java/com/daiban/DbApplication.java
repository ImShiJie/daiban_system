package com.daiban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: daiban_System
 * @description: 数据显示模块
 * @author: 施
 * @create: 2020-02-14 09:53
 **/

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.daiban.dao"})
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class,args);
    }
}
