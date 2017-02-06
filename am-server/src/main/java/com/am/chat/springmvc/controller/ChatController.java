package com.am.chat.springmvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.am.chat.common.util.JedisUtil;
import com.am.chat.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Random;
import java.util.Set;


@Controller
@RequestMapping("/chat")
public class ChatController {
	private static Logger logger = LogManager.getLogger(ChatController.class);
	
	// 跳转到聊天室页面
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public ModelAndView mainpage(HttpServletRequest request) {
		//判断，如果没有session，则跳到登录页面
		HttpSession session = request.getSession();
		logger.info(session.getAttribute("loginUser"));
		if(null==session.getAttribute("loginUser")){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("main");
		}
	}

	@RequestMapping(value = "chatHistory", method = RequestMethod.GET)
	@ResponseBody
	public Set chatHistory(HttpServletRequest request) {
		return JedisUtil.zrange("chat_messages",-100,-1);
	}

}
