package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.SharesResponse;

public interface ShareFacade {
    SharesResponse getShares(String login, String country, String region, String city);
}
