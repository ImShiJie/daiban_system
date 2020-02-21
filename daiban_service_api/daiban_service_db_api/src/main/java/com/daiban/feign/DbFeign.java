package com.daiban.feign;


import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import com.daiban.pojo.User_Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "db")//服务的名字
@RequestMapping("/db")
public interface DbFeign {

    /**
     * 展示所有带班人员
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<UserClass> findAll();

    /**
     * 查询当前用户带班详情
     * @RequestParam("u_name"): 必须要写，不然参数传不过去
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/userFindAll/")
    List<User> userFindAll(@RequestParam("u_name") String u_name);

    @RequestMapping(method = RequestMethod.GET,value = "/addressFindAll/")
    List<User_Address> addressFindAll();

    @RequestMapping(method = RequestMethod.GET,value = "/findMonth/")
    List<Integer> findMonth();
}
