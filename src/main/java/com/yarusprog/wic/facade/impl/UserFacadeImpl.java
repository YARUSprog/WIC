package com.yarusprog.wic.facade.impl;

import java.util.Arrays;

import com.yarusprog.wic.dto.ContactDto;
import com.yarusprog.wic.dto.FriendListResponce;
import com.yarusprog.wic.dto.RatingResponse;
import com.yarusprog.wic.dto.TypeContact;
import com.yarusprog.wic.dto.UserDto;
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

    @Override
    public FriendListResponce getFriends(final String login) {
        return getFriendListResponceTestData(isLoginValid(login));
    }

    private Boolean isLoginValid(final String login) {
        return !StringUtils.isEmpty(login) && ("myemail@gmail.com".equals(login) || "user@gmail.com".equals(login));
    }

    private UserProfileResponse getUserProfileTestData(final Boolean valid) {
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

    private FriendListResponce getFriendListResponceTestData(final Boolean valid) {
        FriendListResponce friendListResponce = new FriendListResponce();
        if (valid) {
            friendListResponce.setFriends(Arrays.asList(
                    new UserDto("goarmor@gmail.com", 4, "Dima"),
                    new UserDto("yarus@gmail.com", 6, "Yaroslav"),
                    new UserDto("longpenis@gmail.com", 10, "Sergiy"),
                    new UserDto("sasha@gmail.com", 15, "Sasha")
            ));
            friendListResponce.setSuccess(true);
            friendListResponce.setErrorCode(0);
        } else {
            friendListResponce.setSuccess(false);
            friendListResponce.setErrorCode(1);
        }
        return friendListResponce;
    }

    @Override
    public RatingResponse getRatingOfUsers(final String country, final String region, final String city) {
        return getRatingOfUsersTestData(isValidRatingOfUsersRequest(country, region, city));
    }

    private Boolean isValidRatingOfUsersRequest(final String country, final String region,
                                           final String city) {
        return  !StringUtils.isEmpty(country) && !StringUtils.isEmpty(region) && !StringUtils.isEmpty(city) &&
                ("all".equals(country) || "Ukraine".equals(country)) && ("all".equals(region) ||
                "Kiev reg".equals(region)) && ("kiev".equals(city) || "all".equals(city));
    }

    private RatingResponse getRatingOfUsersTestData(final Boolean valid) {
        RatingResponse ratingResponse = new RatingResponse();
        if (valid) {
            ratingResponse.setUsers(Arrays.asList(
                    new UserDto("goarmor@gmail.com", 4, "Dima"),
                    new UserDto("yarus@gmail.com", 6, "Yaroslav"),
                    new UserDto("longpenis@gmail.com", 10, "Sergiy"),
                    new UserDto("sasha@gmail.com", 15, "Sasha"),
                    new UserDto("misha324@gmail.com", 16, "Michail")
            ));
            ratingResponse.setSuccess(true);
            ratingResponse.setErrorCode(0);
        } else {
            ratingResponse.setSuccess(false);
            ratingResponse.setErrorCode(1);
        }
        return ratingResponse;
    }
}
