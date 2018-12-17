package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.FriendListResponce;
import com.yarusprog.wic.dto.RatingResponse;
import com.yarusprog.wic.dto.UserProfileResponse;

public interface UserFacade {
    UserProfileResponse getUserProfile(String login);
    FriendListResponce getFriends(String login);
    RatingResponse getRatingOfUsers(String country, String region, String city);
}
