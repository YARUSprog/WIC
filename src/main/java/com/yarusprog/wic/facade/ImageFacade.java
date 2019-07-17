package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.entity.ImageDto;

public interface ImageFacade {
    ImageDto getImageById(long imageId);
}
