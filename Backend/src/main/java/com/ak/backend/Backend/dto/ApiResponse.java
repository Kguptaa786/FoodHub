package com.ak.backend.Backend.dto;

public class ApiResponse<T> {
    private String msg;
    private boolean success;
    private T result;

    public ApiResponse( String msg, boolean success,T result) {
        this.result = result;
        this.msg = msg;
        this.success = success;
    }

    public ApiResponse(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public ApiResponse() {
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
