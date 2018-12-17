package com.yarusprog.wic.dto;

import java.util.List;

public class FriendListResponce {
    private List<UserDto> friends;
    private Boolean isSuccess;
    private Integer errorCode;

    public FriendListResponce() {}

    public FriendListResponce(final List<UserDto> friends, final Boolean isSuccess, final Integer errorCode) {
        this.friends = friends;
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }

    public List<UserDto> getFriends() {
        return friends;
    }

    public void setFriends(final List<UserDto> friends) {
        this.friends = friends;
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
