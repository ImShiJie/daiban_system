package com.daiban.service;

import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import java.text.ParseException;
import java.util.List;

public interface UserService {

    List<UserClass> findAll() throws ParseException;//查询所有用户

    List<User> nameFindAll(String user_name);//根据用户名查询所有符合条件的数据

    void delete(Integer id);//删除用户

    void addUser(User user);//添加用户
}
