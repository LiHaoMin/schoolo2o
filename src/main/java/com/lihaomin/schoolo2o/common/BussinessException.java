package com.lihaomin.schoolo2o.common;

public class BussinessException extends RuntimeException {
    private ResultCode resultCode;

    public BussinessException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
