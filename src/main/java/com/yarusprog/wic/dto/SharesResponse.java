package com.yarusprog.wic.dto;

import java.util.ArrayList;
import java.util.List;

public class SharesResponse {

    private List<Share> shares;
    private Boolean isSuccess;
    private Integer errorCode;

    public SharesResponse() {
        shares = new ArrayList<>();
        isSuccess = false;
        errorCode = 0;
    }

    public SharesResponse(final List<Share> shares) {
        this.shares = shares;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(final List<Share> shares) {
        this.shares = shares;
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
