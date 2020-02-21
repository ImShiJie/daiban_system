package com.daiban.service.impo;

import com.daiban.dao.User_AddressMapper;
import com.daiban.pojo.User_Address;
import com.daiban.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: daiban
 * @description: 带班地址列表展示
 * @author: 施
 * @create: 2019-11-03 21:09
 **/

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private User_AddressMapper userAddressMapper;

    /**
     * 查询所有带班地址
     * @return
     */
    @Override
    public List<User_Address> findAll() {
        return userAddressMapper.selectAll();
    }

    @Override
    public void addAddress(User_Address user_address) {

    }

    /**
     * 根据地址查询关联中间表的id
     * @param address
     * @return
     */
    @Override
    public User_Address findOneByAdrress(String address) {
        return userAddressMapper.findOneByAddress(address);
    }
}
