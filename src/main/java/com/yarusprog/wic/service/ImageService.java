package com.yarusprog.wic.service;

import com.yarusprog.wic.model.ImageModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    long saveFile(MultipartFile image) throws IOException;
    long saveFile(MultipartFile image, long imageId) throws IOException;
    ImageModel getImageById(long imageId);
}
