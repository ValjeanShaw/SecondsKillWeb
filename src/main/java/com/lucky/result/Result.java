package com.lucky.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: xiaoran
 * @date: 2019-04-20 15:01
 */
@Getter
@Setter
public final class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 数据成功的时候
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result getSuccess(T data) {
        return new Result(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg(), data);
    }

    /**
     * 出错情况
     *
     * @param code
     * @param mess
     * @return
     */
    public static Result getError(Integer code, String mess) {
        return new Result(code, mess, null);
    }

    /**
     *
     * @param codeMsg
     * @return
     */
    public static Result getError(CodeMsg codeMsg,Object... args) {
        return new Result(codeMsg.getCode(), codeMsg.getMsg(), args);
    }
}
