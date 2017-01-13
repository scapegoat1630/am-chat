package com.am.chat.websocket;

/**
 * Created by zhangpeng12 on 2017/1/12.
 */
public enum SysEnumType {

    LogIn(100,"LogIn"),
    LogOut(100,"LogOut");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 代码
    private int code;
    // 状态
    private String  message;
    SysEnumType(int code,String message){
        this.code = code;
        this.message = message;

    }


}
