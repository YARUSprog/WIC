package com.yarusprog.wic.controller;

import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.UserProfileResponse;
import com.yarusprog.wic.facade.ShareFacade;
import com.yarusprog.wic.facade.UserFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WicRestController {

    @Autowired
    private ShareFacade shareFacade;

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/shares")
    public SharesResponse getShares(@RequestParam(value = "login", required = false) String login,
                                          @RequestParam(value = "country", required = false) String country,
                                          @RequestParam(value = "region", required = false) String region,
                                          @RequestParam(value = "city", required = false) String city) {
        return shareFacade.getShares(login, country, region, city);
    }

    @GetMapping("/profile")
    public UserProfileResponse getUserProfile(@RequestParam(value = "login", required = false) String login) {
        return userFacade.getUserProfile(login);
    }
}
