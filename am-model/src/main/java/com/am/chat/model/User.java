package com.chat.entity;

import com.google.gson.annotations.Expose;

//用户
public class User {
	@Expose
	private String id;//唯一标识属性
	@Expose
	private String nickname;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + nickname  + "]";
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
