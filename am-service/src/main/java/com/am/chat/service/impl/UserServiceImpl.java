package com.am.chat.service.impl;

import com.am.chat.model.User;
import com.am.chat.model.UserExample;
import com.am.chat.model.vo.UserRegisterRequest;
import com.am.chat.mybatis.mapper.UserMapper;
import com.am.chat.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public User login(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() == 1){
            return users.get(0);
        }else{
            return  null;
        }
    }

    @Transactional
    public boolean validUserName(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null || users.size() == 0){
            return true;
        }else{
            return  false;
        }
    }
    @Transactional
    public User register(UserRegisterRequest userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        userMapper.insert(user);
        return user;
    }
}
