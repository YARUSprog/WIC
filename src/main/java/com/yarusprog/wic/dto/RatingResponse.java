package com.yarusprog.wic.dto;

import java.util.List;

public class RatingResponse {
    private List<UserDto> users;
    private Boolean isSuccess;
    private Integer errorCode;

    public RatingResponse() {
    }

    public RatingResponse(final List<UserDto> users, final Boolean isSuccess, final Integer errorCode) {
        this.users = users;
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(final List<UserDto> users) {
        this.users = users;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(final Boolean success) {
        isSuccess = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final Integer errorCode) {
        this.errorCode = errorCode;
    }
}
