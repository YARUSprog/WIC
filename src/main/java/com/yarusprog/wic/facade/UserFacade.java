package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.FriendListResponce;
import com.yarusprog.wic.dto.RatingResponse;
import com.yarusprog.wic.dto.Response;
import com.yarusprog.wic.dto.UserProfileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserFacade {
    UserProfileResponse getUserProfile(String login);
    FriendListResponce getFriends(String login);
    RatingResponse getRatingOfUsers(String country, String region, String city);
    Response addContactToUser(String login, String typeContact, String contact);
    Response setPhotoToUser(String login, MultipartFile photo);
}
