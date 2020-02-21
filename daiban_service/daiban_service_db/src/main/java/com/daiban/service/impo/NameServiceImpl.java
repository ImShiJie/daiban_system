package com.daiban.service.impo;

import com.daiban.dao.User_NameMapper;
import com.daiban.pojo.User_Name;
import com.daiban.service.NameService;
import com.daiban.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: daiban
 * @description: 用户姓名表
 * @author: 施
 * @create: 2019-11-08 16:51
 **/

@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private User_NameMapper user_nameMapper;

    /**
     * 根据用户姓名查询关联中间表id
     * @param name
     * @return
     */
    @Override
    public User_Name findOneByName(String name) {
        return user_nameMapper.findOneByName(name);
    }

    /**
     * 添加用户姓名和id
     * @param name
     */
    @Override
    public void addUserName(String name) {
        user_nameMapper.addUserName(name,Integer.parseInt(UuidUtil.randomDigitNumber(9)));
    }
}
