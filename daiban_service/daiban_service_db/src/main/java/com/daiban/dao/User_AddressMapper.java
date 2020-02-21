package com.daiban.dao;

import com.daiban.pojo.User_Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: daiban
 * @description: 带班地址列表展示
 * @author: 施
 * @create: 2019-11-03 21:07
 **/

@Repository
public interface User_AddressMapper extends Mapper<User_Address> {

    @Select("SELECT * FROM user_address WHERE address = #{address}")
    User_Address findOneByAddress(@Param("address") String address);
}
