package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.entity.CreateShareDto;
import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.model.ShareModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ShareConverter {

    private static final String PRODUCT_PHOTO_PATH = "product.photo.path";

    @Autowired
    private Environment env;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemConverter itemConverter;

    public ShareModel convertToModel(final ShareDto source) {
        final ShareModel shareModel = new ShareModel();
        modelMapper.map(source, shareModel);
        return shareModel;
    }

    public ShareModel convertToModel(final CreateShareDto source) {
        final ShareModel shareModel = new ShareModel();
        modelMapper.map(source, shareModel);
        return shareModel;
    }

    public ShareDto convertToDto(final ShareModel source) {
        final ShareDto shareDto = new ShareDto();
        modelMapper.map(source, shareDto);
        shareDto.setPhotoProductUrl(Objects.nonNull(source.getProductImageId()) ?
                env.getProperty(PRODUCT_PHOTO_PATH) + source.getProductImageId() :
                null);
        return shareDto;
    }
}
