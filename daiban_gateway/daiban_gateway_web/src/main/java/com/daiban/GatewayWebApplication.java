package com.daiban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-12 19:50
 **/

@SpringBootApplication
@EnableEurekaClient
public class GatewayWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayWebApplication.class,args);
    }

    /**
     * 创建用户唯一标识 使用IP作为用户唯一标识，来根据IP限流操作
     */
    @Bean(name = "ipKeyResolver")
    public KeyResolver userKeyResolver(){

        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
//                return Mono.just("需要使用的用户身份识别唯一标识【IP】");
                //用户请求的IP地址，用于唯一标识限流操作
                String ip = exchange.getRequest().getRemoteAddress().getHostString();
                return Mono.just(ip);
            }
        };
    }

}
