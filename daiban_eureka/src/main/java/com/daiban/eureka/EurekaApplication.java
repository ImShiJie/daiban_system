package com.daiban.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: changgou_parent
 * @description:
 * @author: 施
 * @create: 2019-12-22 12:31
 **/

@SpringBootApplication
@EnableEurekaServer // 声明当前的工程是eureka的注册中心，开启服务

public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
