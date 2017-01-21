package com.am.chat.model.vo;

/**
 * @author hujunliang
 * @since 2016-01-05 18:38
 */
public class ErrorResponse extends Response {
    protected String code;
    protected String message;

    public ErrorResponse() {

    }

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(String requestId, String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
