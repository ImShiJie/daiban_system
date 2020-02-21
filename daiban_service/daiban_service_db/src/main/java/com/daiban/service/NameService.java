package com.daiban.service;


import com.daiban.pojo.User_Name;

public interface NameService {

    User_Name findOneByName(String name);//根据姓名查询关联中间表id

    void addUserName(String name);//添加新用户姓名
}
