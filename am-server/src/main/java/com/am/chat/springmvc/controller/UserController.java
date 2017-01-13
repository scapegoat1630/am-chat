package com.am.chat.springmvc.controller;

import com.am.chat.model.User;
import com.am.chat.model.vo.UserVo;
import com.am.chat.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangpeng12 on 2016/12/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/get")
    @ResponseBody
    public UserVo getUser(@RequestParam(value="id")Integer id){
        UserVo userVo = new UserVo();
        User  user = userService.getUserById(id);
        BeanUtils.copyProperties(user,userVo);
        return  userVo;
    }
}
