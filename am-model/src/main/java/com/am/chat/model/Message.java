package com.chat.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
/**
 * DTO类，用来存放聊天的消息
 * 
 *
 */
public class Message {

	//发送者
	@Expose
	public String from;
	//发送者名称
	@Expose
	public String fromName;
	//接收者
	@Expose
	public String to;
	//发送的文本
	@Expose
	public String text;
	//发送日期
	@Expose
	public String date;
	
	//在线用户列表
	@Expose
	List<User> userList = new ArrayList<>();
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		this.date=sdf.format(date);  
	}
	@Override
	public String toString() {
		return "Message [from=" + from + ", fromName=" + fromName + ", to=" + to + ", text=" + text + ", date=" + date
				+ ", userList=" + userList + "]";
	}
	
	

}
