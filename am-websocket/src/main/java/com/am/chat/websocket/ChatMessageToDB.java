package com.chat.websocket;

import com.chat.entity.Message;

public interface ChatMessageToDB{
	
	public Message select();
	
	public int insert(String message);
}
