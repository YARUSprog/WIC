package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.UserProfileResponse;

public interface UserFacade {
    UserProfileResponse getUserProfile(String login);
}
