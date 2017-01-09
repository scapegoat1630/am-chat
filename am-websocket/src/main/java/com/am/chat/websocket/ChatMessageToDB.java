package com.am.chat.websocket;


import com.am.chat.model.Message;

public interface ChatMessageToDB{
	
	public Message select();
	
	public int insert(String message);
}
