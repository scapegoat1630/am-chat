package com.am.chat.model;

import java.util.Date;

/**
 * DTO类，用来存放聊天的消息
 */
public class Message {
	//发送者
	public String from;
	//发送者名称
	public String fromName;
	//接收者
	public String to;
	//发送的文本
	public String text;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//发送日期
	public Date date;


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	@Override
	public String toString() {
		return "Message{" +
				"from='" + from + '\'' +
				", fromName='" + fromName + '\'' +
				", to='" + to + '\'' +
				", text='" + text + '\'' +
				", date='" + date + '\'' +
				'}';
	}
}
