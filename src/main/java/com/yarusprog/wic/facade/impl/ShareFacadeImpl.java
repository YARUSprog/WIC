package com.yarusprog.wic.facade.impl;

import com.yarusprog.wic.converter.ShareConverter;
import com.yarusprog.wic.dto.SharesResponse;
import com.yarusprog.wic.dto.ShortShareInfoDto;
import com.yarusprog.wic.dto.entity.CreateShareDto;
import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.facade.ShareFacade;
import com.yarusprog.wic.model.ShareModel;
import com.yarusprog.wic.model.ShareState;
import com.yarusprog.wic.repository.AddressRepository;
import com.yarusprog.wic.repository.ItemRepository;
import com.yarusprog.wic.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Arrays;

@Component
public class ShareFacadeImpl implements ShareFacade {

    private static final String IMAGE_UPLOAD_BASE_PATH = "upload.images.path";
    private static final String PRODUCT_PHOTO_PATH = "product.photo.path";

    private static final Logger LOG = LoggerFactory.getLogger(ShareFacadeImpl.class);

    @Autowired
    private ShareService shareService;

    @Autowired
    private ShareConverter shareConverter;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private Environment env;

    @Override
    public ShareDto saveShare(final CreateShareDto createShareDto) {
        ShareModel shareModel = shareConverter.convertToModel(createShareDto);
        shareModel.setDate(new Timestamp(System.currentTimeMillis()));
        addressRepository.save(shareModel.getPlaceAddress());
        shareService.saveShare(shareModel);
        shareModel.getItems().forEach(itemModel -> {
            itemModel.setShare(shareModel);
            itemRepository.save(itemModel);
        });

        return shareConverter.convertToDto(shareModel);
    }

    @Override
    public ShareDto uploadPhotoForShareProduct(final MultipartFile photo, final Long shareId) {
        return shareConverter.convertToDto(shareService.savePhotoForShareProduct(photo, shareId));
    }

    public SharesResponse getShares(final String login, final String country, final String region, final String city) {
        return getShareRequestTestData(isValidGetShareRequest(login, country, region, city));
    }

    private Boolean isValidGetShareRequest(final String login, final String country, final String region,
                                         final String city) {
        return !StringUtils.isEmpty(login) && !StringUtils.isEmpty(country) &&
                !StringUtils.isEmpty(region) && !StringUtils.isEmpty(city) &&
                "user@gmail.com".equals(login) && ("all".equals(country) || "Ukraine".equals(country)) &&
                ("all".equals(region) || "Kiev reg".equals(region)) && ("kiev".equals(city) || "all".equals(city));
    }

    private SharesResponse getShareRequestTestData(final Boolean valid) {
        SharesResponse sharesResponse;
        if (valid) {
            ShortShareInfoDto mcdonaldShare = new ShortShareInfoDto("/images/mcdonalds-logo.png", "Macdonalds", 55,
                    10, "#FF1493", ShareState.ACTIVE.ordinal());
            ShortShareInfoDto cocaColaShare = new ShortShareInfoDto("/images/cocacola-logo.png", "Cocacola", 23,
                    0, "#FFA500", ShareState.SOON.ordinal());
            ShortShareInfoDto cocaColaShare2 = new ShortShareInfoDto("/images/cocacola-logo.png", "Cocacola", 44,
                    0, "#32CD32", ShareState.COMPLETED.ordinal());
            sharesResponse = new SharesResponse(Arrays.asList(mcdonaldShare, cocaColaShare, cocaColaShare2));
            sharesResponse.setSuccess(true);
            sharesResponse.setErrorCode(0);
        } else {
            sharesResponse = new SharesResponse();
            sharesResponse.setSuccess(false);
            sharesResponse.setErrorCode(1);
        }
        return sharesResponse;
    }
}
