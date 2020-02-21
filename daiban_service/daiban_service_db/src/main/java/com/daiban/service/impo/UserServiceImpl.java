package com.daiban.service.impo;

import com.daiban.dao.UserMapper;
import com.daiban.pojo.User;
import com.daiban.pojo.UserClass;
import com.daiban.pojo.User_Name;
import com.daiban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: daiban
 * @description: 用户详情页展示
 * @author: 施
 * @create: 2019-11-03 12:44
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private NameServiceImpl nameService;
    @Autowired


    /**
     * 查询所有符合条件的用户
     *
     * @return
     */
    public List<UserClass> findAll() {
        List<UserClass> all = userMapper.findAll();
        for (UserClass userClass : all) {
            //未付金额=（总带班金额+总加班金额）-已付金额
            userClass.setUserNon_Payment((userClass.getAcount_money() + userClass.getAcount_overtime()) - userClass.getAcount_money_start());
        }
        return all;
    }

    /**
     * 查询当前月份
     */
    public List<Integer> findMonth() {
        List<Integer> arrMonth = new LinkedList<>();
        List<User> all = userMapper.selectAll();
        System.out.println(all);
        for (User user : all) {
            int month = user.getU_date().getMonth();
            System.out.println(month);
            arrMonth.add(month);
        }
        System.out.println(arrMonth);
        return arrMonth;
    }

    /**
     * 用户详情页列表展示
     *
     * @return
     */
    public List<User> nameFindAll(String user_name) {
        return userMapper.nameFindAll(user_name);
    }

    /**
     * 根据id删除用户数据
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        //添加关联地址id
        user.setU_address_id(addressService.findOneByAdrress(user.getU_address()).getAddress_id());

        //添加关联姓名id
        User_Name oneByName = nameService.findOneByName(user.getU_name());
        //判断是否存在此用户
        if (oneByName == null || "".equals(oneByName))
            //不存在则去添加用户
            nameService.addUserName(user.getU_name());
            //为用户带班信息设置关联姓名表中的id
            user.setU_user_id(oneByName.getU_id());
            //存在者根据用户id添加用户带班信息
            userMapper.insert(user);
    }
}
