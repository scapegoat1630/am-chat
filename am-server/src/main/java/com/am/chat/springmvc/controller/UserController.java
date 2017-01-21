package com.am.chat.springmvc.controller;

import com.am.chat.model.User;
import com.am.chat.model.vo.*;
import com.am.chat.model.vo.ResponseStatus;
import com.am.chat.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhangpeng12 on 2016/12/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);
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

    /**
     *  跳转到登录页面
     * @return
     */
    @RequestMapping(value = "loginpage", method = RequestMethod.GET)
    public ModelAndView loginpage() {
        return new ModelAndView("login");
    }

    /**
     * 注册名是否已经存在
     * @param name 用户输入的注册名
     * @return 查询结果
     */
    @RequestMapping(value="/validRegisterName", method = RequestMethod.GET)
    @ResponseBody
   public Boolean validRigisterName(@RequestParam(value="name")String  name){
        logger.info("name:{}",name);
      if(StringUtils.isNotEmpty(name)){
          return userService.validUserName(name);
      }
        return false;
   }


    // 登录进入聊天主页面
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value="name")String  name,@RequestParam(value="password")String  password, HttpServletRequest request) {
        logger.info("name:{},password:{}",name,password);
        HttpSession session = request.getSession();
        // 判断是否是一个已经登录的用户，没有则登录
        if (null != session.getAttribute("loginUser")) {
            // 清除旧的用户
            session.removeAttribute("loginUser");
        }
        //登录操作
        User loginUser = null;
        if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(password)){
            loginUser = userService.login(name,password);
        }
        // 将用户放入session
       if(loginUser != null){
           logger.info("userId:{},userName:{},userNickName:{}", loginUser.getId(), loginUser.getName(), loginUser.getNickname());
           session.setAttribute("loginUser", loginUser);
           return new ModelAndView("redirect:/chat/mainpage");
       }
        return new ModelAndView("redirect:loginpage");
    }

    /**
     * 注用户注册
     * @param vo 用户注册信息
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Response register(UserRegisterRequest vo) {
        logger.info("UserRegisterRequest:{}", vo);
        String error = null;
        if (StringUtils.isEmpty(vo.getName())) {
            error = "Invalid name";
        } else if (StringUtils.isEmpty(vo.getPassword())) {
            error = "Invalid ";
        } else if (vo.getAge()== null ||  vo.getAge()<= 0 ) {
            error = "Invalid age";
        } else if (StringUtils.isEmpty(vo.getNickname())) {
            error = "Invalid Nickname";
        }
        if (StringUtils.isNotEmpty(error)){
            logger.info("error:{}",error);
            return new ErrorResponse(ResponseStatus.Invalid.getCode(),error);
        }
        User user = null;
        try{
            user =  userService.register(vo);
        }catch (Exception e){
            logger.error(e);
        }
        logger.info(user);
        if(user != null){
            return BaseSuccessResponse.SUCCESS;
        }else {
            return new ErrorResponse(ResponseStatus.InternalError.getCode()," userService.register error");
        }
    }
}
