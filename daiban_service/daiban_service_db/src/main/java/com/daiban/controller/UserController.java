package com.daiban.controller;

import com.daiban.entiy.Result;
import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import com.daiban.pojo.User_Address;
import com.daiban.service.impo.AddressServiceImpl;
import com.daiban.service.impo.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: daiban
 * @description: 用户详情页列表展示
 * @author: 施
 * @create: 2019-11-03 12:47
 **/

@RequestMapping("/db")
@RestController
/***
 * @CrossOrigin：跨域
 *      就是A域名访问B域名的数据
 *      域名或者请求端口或者协议不一致时，就是跨域
 */
@CrossOrigin
public class UserController {

//    private String u_name;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private AddressServiceImpl addressServiceImpl;

    /**
     * 查询月份
     */
    @RequestMapping(method = RequestMethod.GET,value = "/findMonth")
    public List<Integer> findMonth(){
        return userServiceImpl.findMonth();
    }

    /**
     * 查询所有带班人员信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserClass> findAll(){
        return userServiceImpl.findAll();
    }

    /**
     * 查询当前用户带班详情
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/userFindAll")
    public List<User> userFindAll(String u_name){
        return userServiceImpl.nameFindAll(u_name);
    }


    /**
     * 根据id删除用户数据
     */
    @RequestMapping("/delete")
    public void delete(Integer id){
        userServiceImpl.delete(id);
    }


    /**
     * 添加用户
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        return new Result();
    }

    /**
     * 返回地址列表数据
     * @return
     */
    @RequestMapping(value = "/addressFindAll",method = RequestMethod.GET)
    public List<User_Address> addressFindAll(){
        return addressServiceImpl.findAll();
    }
}
