package com.daiban.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.daiban.feign.DbFeign;
import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import com.daiban.pojo.User_Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-14 15:44
 **/

@Controller
@RequestMapping(value = "/db")
public class DbController {

    @Autowired
    private DbFeign dbFeign;

    @RequestMapping(method = RequestMethod.GET,value = "/findAll")
    @ResponseBody  //用于返回数据给前端，不加这个注解无法返回
    public List<UserClass> findAll(){
        return dbFeign.findAll();
    }

    @GetMapping("/login")
    public String login(){
        return "DaiBan_Statistics";
    }

    /**
     * 查询当前用户带班详情
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/userFindAll")
    public String userFindAll(@RequestParam(required = false) String u_name,Model md){
        List<User> users = dbFeign.userFindAll(u_name);
        String json = JSONArray.toJSONString(users);//转换为json对象
        md.addAttribute("users",json);
        return "user_index";
    }

    @RequestMapping(value = "/addressFindAll",method = RequestMethod.GET)
    @ResponseBody
    public List<User_Address> addressFindAll() {
        return dbFeign.addressFindAll();
    }

/*    @RequestMapping(method = RequestMethod.GET,value = "/findMonth")
    public List<Integer> findMonth(){
        return dbFeign.findMonth();
    }*/
}
