package com.lucky.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lucky.result.CodeMsg;
import com.lucky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error(e.toString());
        if (e instanceof GlobalException) {
            /**
             * 业务内的异常
             */
            GlobalException ex = (GlobalException) e;
            return Result.getError(ex.getCode(), ex.getMsg());
        } else if (e instanceof BindException) {
            /**
             * 数据校验异常
             */
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.getError(CodeMsg.BIND_ERROR, msg);
        } else {
            /**
             * 通用异常
             */
            return Result.getError(CodeMsg.SERVER_EXCEPTION);
        }
    }
}
