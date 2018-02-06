package com.million.server.common.response;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:41
 * Description:
 */
public enum BaseResponseCode {
    OK(200, "请求成功"),
    NO(100, "请求失败"),
    EXCEPTION(500, "程序出现异常"),
    TOKEN_FAIL_CREATE(501, "用户名或密码错误");
    private final int code;
    private final String message;

    BaseResponseCode(int code, String message) {
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
