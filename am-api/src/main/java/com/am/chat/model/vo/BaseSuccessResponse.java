package com.am.chat.model.vo;

/**
 * Created by zhangpeng12 on 2016/12/6.
 */
public class BaseSuccessResponse extends Response{
    public static final BaseSuccessResponse SUCCESS = new BaseSuccessResponse(true);
    public static final BaseSuccessResponse FAIL = new BaseSuccessResponse(false);
    private Boolean success = true;

    public BaseSuccessResponse(Boolean success) {
        this.success = success;
    }
    public BaseSuccessResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
