package com.yarusprog.wic.facade.impl;

import java.util.Arrays;

import com.yarusprog.wic.dto.ContactDto;
import com.yarusprog.wic.dto.TypeContact;
import com.yarusprog.wic.dto.UserProfileResponse;
import com.yarusprog.wic.facade.UserFacade;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserFacadeImpl implements UserFacade {

    @Override
    public UserProfileResponse getUserProfile(final String login) {
        return getUserProfileTestData(isLoginValid(login));
    }

    private Boolean isLoginValid(final String login) {
        return !StringUtils.isEmpty(login) && ("myemail@gmail.com".equals(login) || "user@gmail.com".equals(login));
    }

    public UserProfileResponse getUserProfileTestData(final Boolean valid) {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        if (valid) {
            userProfileResponse.setUserName("Yarik&Dima");
            userProfileResponse.setPhotoUrl("/images/mcdonalds-logo.png");
            userProfileResponse.setVinsCount(10);
            userProfileResponse.setRange(2.3F);
            userProfileResponse.setPointsCount(Arrays.asList(5, 3, 23, 9));
            userProfileResponse.setContacts(
                    Arrays.asList(
                            new ContactDto(TypeContact.PHONE_NUMBER, "+38415426785"),
                            new ContactDto(TypeContact.SKYPE, "dimas"),
                            new ContactDto(TypeContact.VIBER, "goarmor")
                    ));
            userProfileResponse.setSuccess(true);
            userProfileResponse.setErrorCode(0);
        } else {
            userProfileResponse.setSuccess(false);
            userProfileResponse.setErrorCode(1);
        }
        return userProfileResponse;
    }
}
