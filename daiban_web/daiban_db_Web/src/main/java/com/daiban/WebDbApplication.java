package com.daiban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-14 15:41
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.daiban.feign")
public class WebDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDbApplication.class,args);
    }
}
