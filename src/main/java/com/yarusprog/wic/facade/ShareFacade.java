package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.entity.CreateShareDto;
import com.yarusprog.wic.dto.entity.ShareDto;
import org.springframework.web.multipart.MultipartFile;

public interface ShareFacade {
    ShareDto saveShare(ShareDto shareDto);
    String savePhoto(MultipartFile photo, Long dirName, String fileName);
    SharesResponse getShares(String login, String country, String region, String city);
}
