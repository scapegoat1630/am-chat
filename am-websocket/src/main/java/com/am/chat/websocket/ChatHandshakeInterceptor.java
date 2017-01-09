package com.am.chat.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.am.chat.model.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
/**
 * websocket的链接建立是基于http握手协议，我们可以添加一个拦截器处理握手之前和握手之后过程
 * 
 *
 */
@Component
public class ChatHandshakeInterceptor implements HandshakeInterceptor{
	private static Logger logger = LogManager.getLogger(ChatHandshakeInterceptor.class);

	/**
     * 握手之前，若返回false，则不建立链接
     */
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			//如果用户已经登录，允许聊天
			if(session.getAttribute("loginUser")!=null){
				//获取登录的用户
				User loginUser=(User)session.getAttribute("loginUser") ;
				//将用户放入socket处理器的会话(WebSocketSession)中
				attributes.put("loginUser", loginUser);
				logger.info("ChatHandshake SUCCESS:user has login");
			}else{
				//用户没有登录，拒绝聊天
				//握手失败！
				logger.info("ChatHandshake ERROR:user haven`t login");
				return false;
			}
		}
		return true;
	}
	/**
	 * 握手之后
	 */
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		logger.info("afterHandshake:handshake finish");
	}

}
