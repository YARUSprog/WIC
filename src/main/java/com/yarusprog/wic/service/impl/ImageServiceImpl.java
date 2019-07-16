package com.yarusprog.wic.service.impl;

import com.google.common.base.Preconditions;
import com.yarusprog.wic.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger LOG = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public String saveFile(final MultipartFile image, final String imageDir, final String fileName) {
        Preconditions.checkNotNull(image, "Image can't be null!");
        Preconditions.checkNotNull(imageDir, "Name of directory can't be null!");
        Preconditions.checkNotNull(fileName, "File name can't be null!");

        new File(imageDir).mkdir();
        final Path filePath = Paths.get(imageDir, fileName);

        try {
            Files.write(filePath, image.getBytes());
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.info("File " + fileName + " successfully saved !");

        return filePath.toString();
    }
}
