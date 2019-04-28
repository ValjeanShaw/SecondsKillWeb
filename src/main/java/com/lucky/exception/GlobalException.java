package com.lucky.exception;


import com.lucky.result.CodeMsg;

public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.getMsg());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

    public String getMsg() {
        return cm.getMsg();
    }

    public Integer getCode() {
        return cm.getCode();
    }

}
