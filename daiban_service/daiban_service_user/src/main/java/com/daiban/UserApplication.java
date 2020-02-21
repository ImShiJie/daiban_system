package com.daiban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-12 20:44
 **/

@SpringBootApplication
@MapperScan(basePackages = {"com.daiban.dao"})
@EnableEurekaClient
public class UserApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class,args);
    }
}
