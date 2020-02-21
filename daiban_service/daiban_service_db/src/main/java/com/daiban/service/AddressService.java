package com.daiban.service;


import com.daiban.pojo.User_Address;

import java.util.List;

public interface AddressService {

    List<User_Address> findAll();//查询所有带班地址

    void addAddress(User_Address user_address);//添加地址

    User_Address findOneByAdrress(String address);//根据地址查询地址关联中间表的id
}
