package com.yarusprog.wic.facade.impl;

import com.yarusprog.wic.dto.*;
import com.yarusprog.wic.facade.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
public class UserFacadeImpl implements UserFacade {

    private static final String photoUploadPath = "upload.images.path";

    private static final Logger LOG = LoggerFactory.getLogger(UserFacadeImpl.class);

    private List<UserDto> users;
    private List<ContactDto> contacts;
    private Map<String, List<ContactDto>> userContacts;

    @Autowired
    private Environment env;


    {
        users = Arrays.asList(
                new UserDto("goarmor@gmail.com", 4, "Dima"),
                new UserDto("yarus@gmail.com", 6, "Yaroslav"),
                new UserDto("sergiy@gmail.com", 10, "Sergiy"),
                new UserDto("sasha@gmail.com", 15, "Sasha"),
                new UserDto("user@gmail.com", 16, "Michail")
        );
        contacts = Arrays.asList(
                new ContactDto(TypeContact.PHONE_NUMBER, "+38415426785"),
                new ContactDto(TypeContact.SKYPE, "dimas"),
                new ContactDto(TypeContact.VIBER, "goarmor")
        );
        userContacts = new HashMap<>();
        userContacts.put("user@gmail.com", contacts);
    }

    public UserFacadeImpl() {
    }

    @Override
    public UserProfileResponse getUserProfile(final String login) {
        return getUserProfileTestData(isLoginValid(login));
    }

    @Override
    public FriendListResponce getFriends(final String login) {
        return getFriendListResponceTestData(isLoginValid(login));
    }

    public static Boolean isLoginValid(final String login) {
        return !StringUtils.isEmpty(login) && ("myemail@gmail.com".equals(login) || "user@gmail.com".equals(login));
    }

    private UserProfileResponse getUserProfileTestData(final Boolean valid) {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        if (valid) {
            userProfileResponse.setUserName("Yarik&Dima");
            userProfileResponse.setPhotoUrl("/images/mcdonalds-logo.png");
            userProfileResponse.setWinCount(10);
            userProfileResponse.setRange(2.3F);
            userProfileResponse.setPointsCount(Arrays.asList(5, 0, 0, 9, 0, 3, 0, 6, 23, 0, 9, 13));
            userProfileResponse.setContacts(userContacts.get("user@gmail.com"));
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
            friendListResponce.setFriends(users);
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
        return !StringUtils.isEmpty(country) && !StringUtils.isEmpty(region) && !StringUtils.isEmpty(city) &&
                ("all".equals(country) || "Ukraine".equals(country)) && ("all".equals(region) ||
                "Kiev reg".equals(region)) && ("kiev".equals(city) || "all".equals(city));
    }

    private RatingResponse getRatingOfUsersTestData(final Boolean valid) {
        RatingResponse ratingResponse = new RatingResponse();
        if (valid) {
            ratingResponse.setUsers(users);
            ratingResponse.setSuccess(true);
            ratingResponse.setErrorCode(0);
        } else {
            ratingResponse.setSuccess(false);
            ratingResponse.setErrorCode(1);
        }
        return ratingResponse;
    }

    @Override
    public Response addContactToUser(final String login, final String typeContact, final String contact) {
        if (isLoginValid(login) && !StringUtils.isEmpty(typeContact) && Objects.nonNull(TypeContact.valueOf
                (typeContact)) && !StringUtils.isEmpty(contact)) {
            List<ContactDto> contactDtos = new ArrayList<>(userContacts.get(login));
            contactDtos.add(new ContactDto(TypeContact.valueOf(typeContact), contact));
            userContacts.put(login, contactDtos);
            return new Response(true, 0);
        } else {
            return new Response(false, 1);
        }
    }

    @Override
    public Response setPhotoToUser(final String login, final MultipartFile photo) {
        if(isLoginValid(login)) {
            final String uploadDir = env.getProperty(photoUploadPath);

            new File(uploadDir).mkdir();
            final Path filePath = Paths.get(uploadDir, photo.getOriginalFilename());
            try {
                Files.write(filePath, photo.getBytes());
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
            LOG.info("File " + photo.getOriginalFilename() + " for user " + login + " successfully uploaded !");
            return new Response(true, 0);
        }
        return new Response(false, 1);
    }

    @Override
    public Map<String, List<ContactDto>> getUserContacts() {
        return userContacts;
    }
}
