package com.am.chat.service.impl;

import com.am.chat.model.User;
import com.am.chat.mybatis.mapper.UserMapper;
import com.am.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangpeng12 on 2016/12/22.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

   @Transactional
    public User getUserById(Integer id) {
       return userMapper.selectByPrimaryKey(id);
    }
}
