package com.am.chat.springmvc.controller;


import com.am.chat.model.User;
import com.am.chat.shiro.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/authc")
public class AuthcController {
    private static Logger logger = LogManager.getLogger(AuthcController.class);

    @Autowired
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value="/login")
    public String login(@RequestParam(value="name")String  name,@RequestParam(value="password")String  password, HttpServletRequest request){
        logger.info("name:{},password:{}",name,password);
        HttpSession session = request.getSession();
        // 判断是否是一个已经登录的用户，没有则登录
        if (null != session.getAttribute("loginUser")) {
            // 清除旧的用户
            session.removeAttribute("loginUser");
        }
        try {
            if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(password)){
                this.getAuthService().logIn(name, password);
                 User loginUser = (User)SecurityUtils.getSubject().getSession().getAttribute("loginUser");
                logger.info("userId:{},userName:{},userNickName:{}", loginUser.getId(), loginUser.getName(), loginUser.getNickname());
                session.setAttribute("loginUser", loginUser);
            }
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            return "redirect:/chat/main";
        } catch (AuthenticationException e) {
            //redirectAttributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/user/loginpage";
        }
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        this.getAuthService().logOut();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "/403";
    }
}
