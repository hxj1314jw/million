package com.million.server.common.response;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:42
 * Description:
 */
public enum  BaseResponseStatus {
    NO(0, "请求失败"),
    OK(1, "请求成功");

    private final int code;
    private final String message;

    BaseResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
