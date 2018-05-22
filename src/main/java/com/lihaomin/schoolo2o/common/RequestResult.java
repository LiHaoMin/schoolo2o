package com.lihaomin.schoolo2o.common;

public class RequestResult<T> {
    private boolean success;
    private String errorMsg;
    private long total;
    private T data;

    public RequestResult(T data){
        this.success = true;
        this.data = data;
    }

    public RequestResult(boolean success, String errorMsg){
        this.success =success;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
