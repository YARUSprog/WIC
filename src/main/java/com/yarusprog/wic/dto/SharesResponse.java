package com.yarusprog.wic.dto;

import java.util.ArrayList;
import java.util.List;

public class SharesResponse extends Response {

    private List<Share> shares;

    public SharesResponse() {
        shares = new ArrayList<>();
        setSuccess(false);
        setErrorCode(0);
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

}
