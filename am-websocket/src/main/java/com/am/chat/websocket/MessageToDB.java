package com.chat.websocket;

import com.chat.entity.Message;
import com.chat.utils.MongodbUtils;

public class MessageToDB implements ChatMessageToDB {

	@Override
	public Message select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String message) {
		System.out.println("12331");
		MongodbUtils.insert(message);
		return 0;
	}

}
