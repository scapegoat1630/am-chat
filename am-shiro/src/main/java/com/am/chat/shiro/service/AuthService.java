package com.am.chat.shiro.service;

import org.apache.shiro.authc.AuthenticationException;

import java.util.List;

/**
 * Created by zhangpeng12 on 2017/1/21.
 */
public interface AuthService {
    /**
     * 用户登录接口
     * @param userName 登录用户名
     * @param password 密码
     * @throws AuthenticationException
     */
    void logIn(String userName, String password) throws AuthenticationException;

    /**
     * 用户登出系统
     */
    void logOut();

}
