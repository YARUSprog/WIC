package com.yarusprog.wic.controller;

import java.util.Arrays;

import com.yarusprog.wic.dto.Share;
import com.yarusprog.wic.dto.SharesResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WicRestController {

    @GetMapping("/shares/params")
    public SharesResponse getTestRestData() {
        Share share1 = new Share("/images/mcdonalds-logo.png", "Macdonalds", 55,
                10, 1, true, 0);
        Share share2 = new Share("/images/cocacola-logo.png", "Cocacola", 23,
                5, 1, true, 0);

        return new SharesResponse(Arrays.asList(share1, share2));
    }
}
