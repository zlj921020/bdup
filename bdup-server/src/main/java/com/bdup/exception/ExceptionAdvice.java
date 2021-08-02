package com.bdup.exception;

import com.bdup.core.Result;
import com.bdup.core.ResultCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    private static Log _log = LogFactory.getLog(ExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception ex) {
        _log.error(ex.getMessage(), ex);
            Result result = new Result();
            result.setSuccess(ResultCode.EXCEPTION.getSuccess());
            result.setCode(ResultCode.EXCEPTION.getCode());
            result.setData(new Object());
            result.setMessage(ex.getMessage());
            return result;

    }
}
