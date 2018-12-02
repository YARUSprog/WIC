package com.yarusprog.wic.dto;

import java.util.List;

public class SharesResponse {

    private List<Share> shares;

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
