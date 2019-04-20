package com.lucky.result;

/**
 * 返回码对照表
 * 四位:前2位代表业务   后2位代表详细错误
 *
 * @author: xiaoran
 * @date: 2018-11-29 14:20
 */
public enum CodeMsg {
    SUCCESS(0, "success"),
    /**
     * 通用错误   10xx
     */
    SERVER_EXCEPTION(1000, "服务异常"),
    MISSING_PARAMETER(1001, "缺少必要参数"),
    PARAMETER_FORMAT_ERROR(1002, "参数格式不正确"),
    PARAMETER_MATCH_ERROR(1003, "参数不匹配"),

    /**
     * 登录模块异常
     * 11xx
     */
    ;

    private int code;
    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 根据code获取到相关的错误对象
     *
     * @param code
     * @return
     */
    public static CodeMsg getErrorConstants(int code) {
        CodeMsg[] arr = values();
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            CodeMsg v = arr[i];
            if (code == v.getCode()) {
                return v;
            }
        }
        return null;
    }

    /**
     * 根据code获取到相关的错误对象
     *
     * @param code
     * @return
     */
    public static CodeMsg getErrorConstants(String code) {
        int errorCode = 1000;
        try {
            errorCode = Integer.parseInt(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getErrorConstants(errorCode);
    }

}