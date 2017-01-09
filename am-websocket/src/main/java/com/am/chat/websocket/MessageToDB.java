package com.am.chat.websocket;

import com.am.chat.model.Message;
import com.am.chat.websocket.ChatMessageToDB;

public class MessageToDB implements ChatMessageToDB {

	@Override
	public Message select() {
		return null;
	}

	@Override
	public int insert(String message) {
		return 0;
	}

}
