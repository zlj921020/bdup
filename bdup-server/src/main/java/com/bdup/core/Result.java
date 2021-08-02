package com.bdup.core;

import lombok.Data;

@Data
public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data = new Object();

    /**
     * 构造器私有
     */
    public Result() {
    }

    /**
     * 通用返回成功
     */
    public static Result success() {
        Result result = new Result();
        result.setSuccess(ResultCode.SUCCESS.getSuccess());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(new Object());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }
    /**
     * 通用返回成功
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setSuccess(ResultCode.SUCCESS.getSuccess());
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setData(object);
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }
}
