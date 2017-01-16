package com.am.chat.service;

import com.am.chat.model.User;
import com.am.chat.model.vo.UserRegisterRequest;

/**
 * Created by zhangpeng12 on 2016/12/22.
 */
public interface UserService {
    public User getUserById(Integer id);
    public User login(String username,String password);
    public boolean validUserName(String username);
    public User register(UserRegisterRequest userVo);
}
