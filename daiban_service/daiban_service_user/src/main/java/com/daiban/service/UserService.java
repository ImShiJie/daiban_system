package com.daiban.service;

import com.daiban.dao.UserMapper;
import com.daiban.pojo.User;
import com.daiban.util.BCrypt;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.daiban.util.BCrypt.gensalt;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user
     */
    public boolean add(User user) {
        //密码加密
        String salt = gensalt(10, new SecureRandom());
        String password = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(password);
        Date date = new Date();
        user.setCreated(date);//设置注册时间
        user.setUpdated(date);//第一次设置修改时间，也是注册时间
        user.setStatus("1");//正常使用
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            return false;
        }
        return true;
        /**
         * MD5加密
         */
/*        String salt = RandomString.getRandomString(5);
        user.setSalt(salt);
        try {
            System.out.println(Md5Util.encodeByMd5(password));
            String s = Md5Util.encodeByMd5(password + salt);
            user.setPassword(s);
            Date date = new Date();
            user.setCreated(date);
            user.setUpdated(date);
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public User findById(String username){
        return userMapper.selectByPrimaryKey(username);
    }

    /**
     * 修改密码
     * @param user
     */
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 删除
     * @param id
     */
/*    public void delete(String username){
        userMapper.deleteByPrimaryKey(id);
    }*/


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<User> findPage( int page, int size){
        PageHelper.startPage(page,size);
        return (Page<User>)userMapper.selectAll();
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<User> findList(Map<String,Object> searchMap){
        Example example = createExample(searchMap);
        return userMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String,Object> searchMap){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 用户名
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
           	}
            // 密码
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
           	}
            // 注册手机号
            if(searchMap.get("pone")!=null && !"".equals(searchMap.get("pone"))){
                criteria.andLike("pone","%"+searchMap.get("pone")+"%");
           	}
            // 注册邮箱
            if(searchMap.get("email")!=null && !"".equals(searchMap.get("email"))){
                criteria.andLike("email","%"+searchMap.get("email")+"%");
           	}
            // 昵称
            if(searchMap.get("nick_name")!=null && !"".equals(searchMap.get("nick_name"))){
                criteria.andLike("nick_name","%"+searchMap.get("nick_name")+"%");
           	}
            // 真实姓名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 使用状态（1正常 0非正常）
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
           	}
            // 头像地址
            if(searchMap.get("head_pic")!=null && !"".equals(searchMap.get("head_pic"))){
                criteria.andLike("head_pic","%"+searchMap.get("head_pic")+"%");
           	}
            // QQ号码
            if(searchMap.get("qq")!=null && !"".equals(searchMap.get("qq"))){
                criteria.andLike("qq","%"+searchMap.get("qq")+"%");
           	}
            // 手机是否验证 （0否  1是）
            if(searchMap.get("is_mobile_check")!=null && !"".equals(searchMap.get("is_mobile_check"))){
                criteria.andLike("is_mobile_check","%"+searchMap.get("is_mobile_check")+"%");
           	}
            // 邮箱是否检测（0否  1是）
            if(searchMap.get("is_email_check")!=null && !"".equals(searchMap.get("is_email_check"))){
                criteria.andLike("is_email_check","%"+searchMap.get("is_email_check")+"%");
           	}
            // 性别，1男，0女
            if(searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))){
                criteria.andLike("sex","%"+searchMap.get("sex")+"%");
           	}


        }
        return example;
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public Page<User> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<User>)userMapper.selectByExample(example);
    }

}
