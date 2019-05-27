package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.entity.ShareDto;

public interface ShareFacade {
    void saveShare(ShareDto shareDto);
    SharesResponse getShares(String login, String country, String region, String city);
}
