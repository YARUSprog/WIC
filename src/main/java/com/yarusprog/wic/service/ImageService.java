package com.yarusprog.wic.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveFile(MultipartFile image, String imageDir, String fileName);
}
