package com.am.chat.springmvc.controller;


import com.am.chat.model.User;
import com.am.chat.shiro.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/authc")
public class AuthcController {

    @Autowired
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }



    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        try {
            if(bindingResult.hasErrors()){
                return "/login";
            }
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            this.getAuthService().logIn(user.getName(),user.getPassword());
            return "redirect:/user";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/login";
        }
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        this.getAuthService().logOut();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "/403";
    }
}
