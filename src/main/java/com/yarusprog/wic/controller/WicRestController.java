package com.yarusprog.wic.controller;

import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.facade.ShareFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WicRestController {

    @Autowired
    private ShareFacade shareFacade;

    @GetMapping("/shares")
    public SharesResponse getTestRestData(@RequestParam(value = "login", required = false) String login,
                                          @RequestParam(value = "country", required = false) String country,
                                          @RequestParam(value = "region", required = false) String region,
                                          @RequestParam(value = "city", required = false) String city) {
        return shareFacade.getShares(login, country, region, city);
    }
}
