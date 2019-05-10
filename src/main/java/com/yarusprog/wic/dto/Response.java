package com.yarusprog.wic.dto;

public class Response {

    private boolean isSuccess = true;
    private int errorCode = 0;

    public Response() {
    }

    public Response(final boolean isSuccess, final int errorCode) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(final boolean success) {
        isSuccess = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
}
