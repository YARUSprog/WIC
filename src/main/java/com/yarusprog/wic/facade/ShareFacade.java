package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.entity.CreateShareDto;
import com.yarusprog.wic.dto.entity.ShareDto;
import org.springframework.web.multipart.MultipartFile;

public interface ShareFacade {
    ShareDto saveShare(CreateShareDto createShareDto);
    ShareDto uploadPhotoForShareProduct(MultipartFile photo, Long shareId);
    SharesResponse getShares(String login, String country, String region, String city);
}
