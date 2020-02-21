package com.daiban.controller;

import com.alibaba.fastjson.JSON;
import com.daiban.entiy.Result;
import com.daiban.entiy.StatusCode;
import com.daiban.pojo.User;
import com.daiban.service.UserService;
import com.daiban.util.BCrypt;
import com.daiban.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-13 13:45
 **/

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping(value = "/login")
    public Result login(String username, String password, HttpServletResponse response){

        //查询用户信息
        User user = userService.findById(username);
        if (user == null){
            return new Result(false,StatusCode.ERROR,"账号或密码有误");
        }

        if (BCrypt.checkpw(password,user.getPassword())){
            //创建用户令牌信息
            Map<String,Object> tokenMap = new HashMap<>();
            tokenMap.put("role","USER");
            tokenMap.put("success","SUCCESS");
            tokenMap.put("username",username);

            //生成令牌
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(tokenMap), null);

            //把令牌信息存入到Cookie
            Cookie cookie = new Cookie("Authorization",token);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);

            //把令牌作为参数给用户
            return new Result(true,StatusCode.OK,"登录成功",token);
        }

/*        //对比密码
        try {
            if (Md5Util.encodeByMd5((password+user.getSalt())).equals(user.getPassword())){
                //密码匹配，登录成功
                return new Result(true,StatusCode.OK,"登录成功",user);
            }
        } catch (Exception e) {
            //密码匹配失败，登录失败，账号或密码有误
            return new Result(false,StatusCode.ERROR,"账号或密码有误");
        }*/
        return new Result(false,StatusCode.ERROR,"账号或密码有误");
    }

    //用户注册
    @PostMapping
    public Result add(@RequestBody User user){
        if (userService.add(user)){
            return new Result(true,StatusCode.OK,"注册成功");
        }
        return new Result(false,StatusCode.ERROR,"注册失败");
    }


    @PostMapping(value = "/search" )
    public Result findList(@RequestBody Map searchMap){
        List<User> list = userService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


}