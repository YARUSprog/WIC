package com.yarusprog.wic.facade.impl;

import com.yarusprog.wic.dto.entity.ImageDto;
import com.yarusprog.wic.facade.ImageFacade;
import com.yarusprog.wic.model.ImageModel;
import com.yarusprog.wic.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageFacadeImpl implements ImageFacade {

    @Autowired
    private ImageService imageService;

    @Override
    public ImageDto getImageById(long imageId) {
        final ImageModel imageModel = imageService.getImageById(imageId);
        return new ImageDto(imageModel.getId(), imageModel.getFormat(), imageModel.getImage());
    }
}
