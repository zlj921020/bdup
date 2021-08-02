package com.bdup.core;

import lombok.Getter;

@Getter
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(true,20000, "成功"),

    /* 用户错误：10001-19999*/
    USER_NOT_LOGGED_IN(false,50008, "用户未登录"),

    /* 业务错误：20001-29999 */
    BUSINESS_EXCEPTION(false,50012, "应用级异常"),

    EXCEPTION(false,50016, "其他异常");

    // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;


    /* 权限错误：40001-49999 */
    /**
     * 响应是否成功
     */
    private Boolean success;
    private int code;
    private String message;

    ResultCode(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.message = msg;
    }
}
