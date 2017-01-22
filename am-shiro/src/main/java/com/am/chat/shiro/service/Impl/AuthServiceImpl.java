package com.am.chat.shiro.service.Impl;

import com.am.chat.shiro.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangpeng12 on 2017/1/21.
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * 用户登录接口
     * @param userName 登录用户名
     * @param password 密码
     * @throws AuthenticationException
     */
    public void logIn(String userName, String password) throws AuthenticationException {
        UsernamePasswordToken token= new UsernamePasswordToken(userName,password);
        SecurityUtils.getSubject().login(token);
    }
    /**
     * 用户登出系统
     */
    public void logOut() {
        SecurityUtils.getSubject().logout();
    }

}
