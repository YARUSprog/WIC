package com.yarusprog.wic.facade;

import java.util.List;
import java.util.Map;

import com.yarusprog.wic.dto.*;
import org.springframework.web.multipart.MultipartFile;

public interface UserFacade {
    UserProfileResponse getUserProfile(String login);
    FriendListResponce getFriends(String login);
    AllItemsResponse getAllItems(String login);
    NoticeResponse getNotices(String login);
    RatingResponse getRatingOfUsers(String country, String region, String city);
    void sendGeneratedCodeToUser(String login);
    boolean verifyCode(Integer code);
    Response addContactToUser(String login, String typeContact, String contact);
    Response setPhotoToUser(String login, MultipartFile photo);
    Map<String, List<ContactDto>> getUserContacts();
}
