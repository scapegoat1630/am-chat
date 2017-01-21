package com.am.chat.websocket.model;

import java.util.Date;

/**
 * Created by zhangpeng12 on 2017/1/12.
 */
public class UserVo {
    /**
     *  id
     */
    private Integer id;
    /**
     *name
     */
    private String name;

    /**
     *  nickname
     */
    private String nickname;


    /**
     * headimage
     */
    private String headimage;

    /**
     * state
     */
    private Integer onLineState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public Integer getOnLineState() {
        return onLineState;
    }

    public void setOnLineState(Integer onLineState) {
        this.onLineState = onLineState;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headimage='" + headimage + '\'' +
                ", onLineState=" + onLineState +
                '}';
    }
}
