package com.am.chat.websocket;

import com.alibaba.fastjson.JSON;
import com.am.chat.common.util.JedisUtil;
import com.am.chat.common.util.RedisUtil;
import com.am.chat.websocket.model.Message;
import com.am.chat.websocket.model.SysMessage;
import com.am.chat.model.User;
import com.am.chat.websocket.model.UserVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.*;

/**
 * 
 * WebSocket处理器
 *
 */
@Component("chatWebSocketHandler")
public class ChatWebSocketHandler implements WebSocketHandler {
	private static Logger logger = LogManager.getLogger(ChatWebSocketHandler.class);
	
	//在线用户的SOCKETsession(存储了所有的通信通道)
	public static final Map<Integer, WebSocketSession> USER_SOCKETSESSION_MAP;
	//存储所有的在线用户
	static {
		USER_SOCKETSESSION_MAP = new HashMap<Integer, WebSocketSession>();
	}
	/**
	 * webscoket建立好链接之后的处理函数--连接建立后的准备工作
	 */
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		//将当前的连接的用户会话放入MAP,key是用户编号
		User loginUser=(User) webSocketSession.getAttributes().get("loginUser");
		USER_SOCKETSESSION_MAP.put(loginUser.getId(), webSocketSession);
		//群发消息告知大家
		SysMessage msg = new SysMessage();
		msg.setText("【" + loginUser.getNickname() + "】已登录！");
		msg.setDate(new Date());
		msg.setMessageType(SysEnumType.LogIn.getCode());
		List<UserVo> users = new ArrayList<>();
		Iterator<Map.Entry<Integer,WebSocketSession>> iterator = USER_SOCKETSESSION_MAP.entrySet().iterator();
		while(iterator.hasNext()){
			User user = (User)iterator.next().getValue().getAttributes().get("loginUser");
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(user,userVo);
			users.add(userVo);
		}
		msg.setUsers(users);
		logger.info("message:{}",msg);
		//将消息转换为json
		TextMessage message = new TextMessage(JSON.toJSONString(msg));
		//群发消息
		sendMessageToAll(message);
	}

	
	/**
     * 客户端发送服务器的消息时的处理函数，在这里收到消息之后可以分发消息
     */
	//处理消息：当一个新的WebSocket到达的时候，会被调用（在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理）
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> message) throws Exception {
		//如果消息没有任何内容，则直接返回
		if(message.getPayloadLength()==0)
			return;
		//反序列化服务端收到的json消息
		Message msg = JSON.parseObject(message.getPayload().toString(),Message.class);
		msg.setDate(new Date());
		logger.info("user:{},message:{},time:{}", ((User)(USER_SOCKETSESSION_MAP.get(msg.getFrom()).getAttributes()).get("loginUser")).getNickname(), msg.getText(), msg.getDate());
		//处理html的字符，转义：
		String text = msg.getText();
		//转换为HTML转义字符表示
		String htmlEscapeText = HtmlUtils.htmlEscape(text);
		msg.setText(htmlEscapeText);
		String messageJson= JSON.toJSONString(msg);
		JedisUtil.zadd("chat_messages",msg.getDate().getTime(),messageJson);
		//判断是群发还是单发
		if(msg.getTo()==null||msg.getTo().equals(-1)){
			//群发
			sendMessageToAll(new TextMessage(messageJson));
		}else{
			sendMessageToUser(msg.getTo(), new TextMessage(messageJson));
		}
	}


	/**
     * 消息传输过程中出现的异常处理函数
     * 处理传输错误：处理由底层WebSocket消息传输过程中发生的异常
     */
	public void handleTransportError(WebSocketSession webSocketSession, Throwable exception) throws Exception {
		// 记录日志，准备关闭连接
		logger.info("Websocket异常断开:" + webSocketSession.getId() + "已经关闭");
		//一旦发生异常，强制用户下线，关闭session
		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		//群发消息告知大家
		SysMessage msg = new SysMessage();
		msg.setDate(new Date());
		msg.setMessageType(SysEnumType.LogOut.getCode());
		//获取异常的用户的会话中的用户编号
		User loginUser=(User)webSocketSession.getAttributes().get("loginUser");
		//获取所有的用户的会话
		Set<Map.Entry<Integer, WebSocketSession>> entrySet = USER_SOCKETSESSION_MAP.entrySet();
		List<UserVo> users = new ArrayList<>();
		//并查找出在线用户的WebSocketSession（会话），将其移除（不再对其发消息了。。）
		for (Map.Entry<Integer, WebSocketSession> entry : entrySet) {
			if(entry.getKey().equals(loginUser.getId())){
				msg.setText("【" + loginUser.getNickname() + "】已经退出");
				//清除在线会话
				USER_SOCKETSESSION_MAP.remove(entry.getKey());
				//记录日志：
				logger.info("Socket会话已经移除:用户ID" + entry.getKey());
			}else {
				User user = (User)entry.getValue().getAttributes().get("loginUser");
				UserVo userVo = new UserVo();
				BeanUtils.copyProperties(user,userVo);
				users.add(userVo);
			}
		}
		msg.setUsers(users);
		TextMessage message = new TextMessage(JSON.toJSONString(msg));
		sendMessageToAll(message);
	}


	/**
     * websocket链接关闭的回调
     * 连接关闭后：一般是回收资源等
     */
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		// 记录日志，准备关闭连接
		logger.info("Websocket正常断开:" + webSocketSession.getId() + "已经关闭");
		//群发消息告知大家
		SysMessage msg = new SysMessage();
		msg.setDate(new Date());
		msg.setMessageType(SysEnumType.LogOut.getCode());
		//获取异常的用户的会话中的用户编号
		User loginUser=(User)webSocketSession.getAttributes().get("loginUser");
		//并查找出在线用户的WebSocketSession（会话），将其移除（不再对其发消息了。。）
		List<UserVo> users = new ArrayList<>();
		for (Map.Entry<Integer, WebSocketSession> entry : USER_SOCKETSESSION_MAP.entrySet()) {
			if(entry.getKey().equals(loginUser.getId())){
				//群发消息告知大家
				msg.setText("【" + loginUser.getNickname() + "】已退出");
				//清除在线会话
				USER_SOCKETSESSION_MAP.remove(entry.getKey());
				//记录日志：
				logger.info("Socket会话已经移除:用户ID" + entry.getKey());
			}else {
				User user = (User)entry.getValue().getAttributes().get("loginUser");
				UserVo userVo = new UserVo();
				BeanUtils.copyProperties(user,userVo);
				users.add(userVo);
			}
		}
		msg.setUsers(users);
		TextMessage message = new TextMessage(JSON.toJSONString(msg));
		sendMessageToAll(message);
	}


	 /**
     * 是否支持处理拆分消息，返回true返回拆分消息
     */
	//是否支持部分消息：如果设置为true，那么一个大的或未知尺寸的消息将会被分割，并会收到多次消息（会通过多次调用方法handleMessage(WebSocketSession, WebSocketMessage). ）
	//如果分为多条消息，那么可以通过一个api：org.springframework.web.socket.WebSocketMessage.isLast() 是否是某条消息的最后一部分。
	//默认一般为false，消息不分割
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 
	 * 说明：给某个人发信息
	 * @param id
	 * @param message
	 * @author 
	 * @throws IOException 
	 *
	 */
	private void sendMessageToUser(Integer id, TextMessage message) throws IOException{
		//获取到要接收消息的用户的session
		WebSocketSession webSocketSession = USER_SOCKETSESSION_MAP.get(id);
		if (webSocketSession != null && webSocketSession.isOpen()) {
			//发送消息
			webSocketSession.sendMessage(message);
		}
	}
	
	/**
	 * 
	 * 说明：群发信息：给所有在线用户发送消息
	 * @author 
	 * 
	 */
	private void sendMessageToAll(final TextMessage message){
		//对用户发送的消息内容进行转
		for (Map.Entry<Integer, WebSocketSession> entry : USER_SOCKETSESSION_MAP.entrySet()) {
			//某用户的WebSocketSession
			final WebSocketSession webSocketSession = entry.getValue();
			//判断连接是否仍然打开的
			if(webSocketSession.isOpen()){
				//开启多线程发送消息（效率高）
				new Thread(new Runnable() {
					public void run() {
						try {
							if (webSocketSession.isOpen()) {
								webSocketSession.sendMessage(message);
							}
						} catch (IOException e) {
							logger.error(e);
						}
					}

				}).start();
			}
		}
	}
	
}
