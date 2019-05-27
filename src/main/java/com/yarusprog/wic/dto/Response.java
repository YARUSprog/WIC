package com.yarusprog.wic.dto;

import java.util.List;

public class Response {

    private boolean isSuccess = true;
    private int errorCode = 0;
    private List<String> errors;

    public Response() {
    }

    public Response(List<String> errors) {
        this.errors = errors;
    }

    public Response(final boolean isSuccess, final int errorCode) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }

    public Response(boolean isSuccess, int errorCode, List<String> errors) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
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
