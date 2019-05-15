package com.yarusprog.wic.facade.impl;

import java.util.Arrays;

import com.yarusprog.wic.converter.ShareConverter;
import com.yarusprog.wic.dto.ShortShareInfoDto;
import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.facade.ShareFacade;
import com.yarusprog.wic.model.ShareState;

import com.yarusprog.wic.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ShareFacadeImpl implements ShareFacade {

    @Autowired
    private ShareService shareService;

    @Autowired
    private ShareConverter shareConverter;

    private void saveShare(final ShareDto shareDto) {
        shareService.saveShare(shareConverter.convertToModel(shareDto));
    }

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
            ShortShareInfoDto mcdonaldShare = new ShortShareInfoDto("/images/mcdonalds-logo.png", "Macdonalds", 55,
                    10, "#FF1493", ShareState.ACTIVE.ordinal());
            ShortShareInfoDto cocaColaShare = new ShortShareInfoDto("/images/cocacola-logo.png", "Cocacola", 23,
                    0, "#FFA500", ShareState.SOON.ordinal());
            ShortShareInfoDto cocaColaShare2 = new ShortShareInfoDto("/images/cocacola-logo.png", "Cocacola", 44,
                    0, "#32CD32", ShareState.COMPLETED.ordinal());
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
