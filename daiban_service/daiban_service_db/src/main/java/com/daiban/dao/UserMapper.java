package com.daiban.dao;

import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: daiban
 * @description: 用户详情页
 * @author: 施
 * @create: 2019-11-03 12:42
 **/

@Repository
public interface UserMapper extends Mapper<User> {

    @Select("SELECT * FROM users WHERE u_name= #{u_name}")
    List<User> nameFindAll(@Param("u_name") String u_name);//根据用户名查询

    @Select("SELECT u.`u_name`,u.`u_date`,SUM(u.`u_day`) " +
            "acount_day," +
            "SUM(u.`u_money`) acount_money," +
            "SUM(u.`u_overtime`) acount_overtime," +
            "SUM(u.`u_money_start`) acount_money_start " +
            "FROM users u, user_name  us WHERE u.`u_name` = us.`u_name`  GROUP BY u.`u_name`")
    List<UserClass> findAll();
}
