package com.daiban.pojo.feign;

import com.daiban.entiy.Result;
import com.daiban.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-16 13:57
 **/

@FeignClient(name = "user")
@RequestMapping("/user")
public interface UserFeign {

    @RequestMapping(method = RequestMethod.GET,value = "/login/")
    Result login(String username, String password);

    @RequestMapping(method = RequestMethod.GET,value = "/login/")
    User findUserInfo(String username);
}