package com.daiban.dao;

import com.daiban.pojo.User_Name;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: daiban
 * @description:
 * @author: 施
 * @create: 2019-11-03 08:57
 **/

@Repository
public interface User_NameMapper extends Mapper<User_Name> {

    @Select("SELECT * FROM user_name WHERE u_name = #{u_name}")
    User_Name findOneByName(@Param("u_name") String u_name);

    @Select("insert into user_name (id, u_name, u_id) " +
            "values" +
            " ( null,#{name}, #{md5})")
    void addUserName(@Param("name") String name, @Param("md5") Integer md5);
}
