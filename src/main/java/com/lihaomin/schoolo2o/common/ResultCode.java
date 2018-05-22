package com.lihaomin.schoolo2o.common;

public enum ResultCode {
    SYSTEM_ERROR(00,"系统异常"),
    PARAM_EMPTY(10,"参数为空");

    private int code;
    private String message;

    private ResultCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static ResultCode getResultCode(int code){
        for (ResultCode resultCode : values()) {
            if (resultCode.getCode() == code) {
                return resultCode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
