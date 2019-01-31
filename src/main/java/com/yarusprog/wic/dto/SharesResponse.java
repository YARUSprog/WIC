package com.yarusprog.wic.dto;

import java.util.ArrayList;
import java.util.List;

public class SharesResponse extends Response {

    private List<ShareDto> shares;

    public SharesResponse() {
        shares = new ArrayList<>();
        setSuccess(false);
        setErrorCode(0);
    }

    public SharesResponse(final List<ShareDto> shares) {
        this.shares = shares;
    }

    public List<ShareDto> getShares() {
        return shares;
    }

    public void setShares(final List<ShareDto> shares) {
        this.shares = shares;
    }

}
