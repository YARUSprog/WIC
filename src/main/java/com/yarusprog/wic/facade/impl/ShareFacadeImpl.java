package com.yarusprog.wic.facade.impl;

import java.util.Arrays;

import com.yarusprog.wic.dto.Share;
import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.facade.ShareFacade;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ShareFacadeImpl implements ShareFacade {

    public SharesResponse getShares(final String login, final String country, final String region, final String city) {
        return getShareRequestTestData(isValidGetShareRequest(login, country, region, city));
    }

    private Boolean isValidGetShareRequest(final String login, final String country, final String region,
                                         final String city) {
        return !StringUtils.isEmpty(login) && !StringUtils.isEmpty(country) &&
                !StringUtils.isEmpty(region) && !StringUtils.isEmpty(city) &&
                "user@gmail.com".equals(login) && ("all".equals(country) || "Ukraine".equals(country)) &&
                ("all".equals(region) || "Kiev reg".equals(region)) && ("kiev".equals(city) || "all".equals(city));
    }

    private SharesResponse getShareRequestTestData(final Boolean valid) {
        SharesResponse sharesResponse;
        if (valid) {
            Share mcdonaldShare = new Share("/images/mcdonalds-logo.png", "Macdonalds", 55,
                    10, "#FF1493", 0);
            Share cocaColaShare = new Share("/images/cocacola-logo.png", "Cocacola", 23,
                    5, "#FF1493", 1);
            Share cocaColaShare2 = new Share("/images/cocacola-logo.png", "Cocacola", 44,
                    12, "#FF1493", 2);
            sharesResponse = new SharesResponse(Arrays.asList(mcdonaldShare, cocaColaShare, cocaColaShare2));
            sharesResponse.setSuccess(true);
            sharesResponse.setErrorCode(0);
        } else {
            sharesResponse = new SharesResponse();
            sharesResponse.setSuccess(false);
            sharesResponse.setErrorCode(1);
        }
        return sharesResponse;
    }
}