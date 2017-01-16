package com.am.chat.websocket.model;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangpeng12 on 2017/1/12.
 */
public class SysMessage {

    //发送的文本
    public String text;

    public Integer messageType;

    //发送日期
    public Date date;

    private List<UserVo> users;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public List<UserVo> getUsers() {
        return users;
    }

    public void setUsers(List<UserVo> users) {
        this.users = users;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
