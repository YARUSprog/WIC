package com.yarusprog.wic.facade.impl;

import com.yarusprog.wic.dto.*;
import com.yarusprog.wic.facade.UserFacade;
import com.yarusprog.wic.service.email.EmailService;
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
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class UserFacadeImpl implements UserFacade {

    private static final String photoUploadPath = "upload.images.path";
    private static final int CODE_LOWER_LIMIT = 10000;
    private static final int CODE_UPPER_LIMIT = 100000;
    private static Map<String, CompanyDto> companies = new HashMap();

    private static final Logger LOG = LoggerFactory.getLogger(UserFacadeImpl.class);

    private List<UserDto> users;
    private List<AllItemsDto> allItemsDtos;
    private List<ContactDto> contacts;
    private Map<String, List<ContactDto>> userContacts;

    @Autowired
    private Environment env;

    @Autowired
    private EmailService emailService;


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

    @Override
    public AllItemsResponse getAllItems(final String login) {
        return getAllItemsResponceTestData(isLoginValid(login));
    }

    @Override
    public NoticeResponse getNotices(final String login) {
        return getNoticesTestData(isLoginValid(login));
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

    private AllItemsResponse getAllItemsResponceTestData(final Boolean valid) {
        AllItemsResponse allItemsResponse = new AllItemsResponse();
        if (valid) {
            AllItemsDto mcdonaldItem = new AllItemsDto("testSharedId", "Macdonalds", "/images/mcdonalds-logo.png",
                    "/images/product-macdonalds.png", 55, 10);
            AllItemsDto cocaColaItem = new AllItemsDto("testSharedId2", "Cocacola", "/images/cocacola-logo.png",
                    "/images/product-cocacola.png", 44, 7);
            AllItemsDto cocaColaItem2 = new AllItemsDto("testSharedId3", "Cocacola", "/images/cocacola-logo.png",
                    "/images/product-1-cocacola.png", 44, 5);

            allItemsResponse = new AllItemsResponse(Arrays.asList(mcdonaldItem, cocaColaItem, cocaColaItem2));
            allItemsResponse.setSuccess(true);
            allItemsResponse.setErrorCode(0);
        } else {
            allItemsResponse.setSuccess(false);
            allItemsResponse.setErrorCode(1);
        }
        return allItemsResponse;
    }

    private NoticeResponse getNoticesTestData(final Boolean valid) {
        NoticeResponse noticesResponse = new NoticeResponse();
        if (valid) {
            NoticeDto notice1 = new NoticeDto("test note 1", LocalDateTime.now().minusDays(2).toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
            NoticeDto notice2 = new NoticeDto("test note 2", LocalDateTime.now().minusDays(4).toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
            NoticeDto notice3 = new NoticeDto("test note 3", LocalDateTime.now().minusDays(6).toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
            noticesResponse = new NoticeResponse(Arrays.asList(notice1, notice2, notice3));
            noticesResponse.setSuccess(true);
            noticesResponse.setErrorCode(0);
        } else {
            noticesResponse.setSuccess(false);
            noticesResponse.setErrorCode(1);
        }
        return noticesResponse;
    }

    @Override
    public RatingResponse getRatingOfUsers(final String country, final String region, final String city) {
        return getRatingOfUsersTestData(isValidRatingOfUsersRequest(country, region, city));
    }

    @Override
    public Response registerCompany(final String login, final String address, final String phone) {
        int code = ThreadLocalRandom.current().nextInt(CODE_LOWER_LIMIT, CODE_UPPER_LIMIT);

        final CompanyDto company = new CompanyDto(login, address, phone, code);
        companies.put(phone, company);

        emailService.sendSimpleMessage(login, "Registration code", "Your registration code: " + code);

        return new Response();
    }

    @Override
    public Response verifyCode(final String phone, final Integer code) {
        final CompanyDto company = (CompanyDto) companies.get(phone);

        if (Objects.isNull(company)) {
            return new Response(false, 1);
        } else if (!company.getCode().equals(code)) {
            return new Response(false, 2);
        }
        companies.remove(phone);

        return new Response();
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
