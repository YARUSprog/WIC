package com.yarusprog.wic.service.impl;

import com.google.common.base.Preconditions;
import com.sun.mail.iap.ByteArray;
import com.yarusprog.wic.model.ImageModel;
import com.yarusprog.wic.repository.ImageRepository;
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
import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger LOG = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageRepository imageRepository;

//    @Override
//    public String saveFile(final MultipartFile image, final String imageDir, final String fileName) {
//        Preconditions.checkNotNull(image, "Image can't be null!");
//        Preconditions.checkNotNull(imageDir, "Name of directory can't be null!");
//        Preconditions.checkNotNull(fileName, "File name can't be null!");
//
//        new File(imageDir).mkdir();
//        final Path filePath = Paths.get(imageDir, fileName);
//
//        try {
//            Files.write(filePath, image.getBytes());
//        } catch (IOException e) {
//            LOG.error(e.getMessage(), e);
//        }
//        LOG.info("File " + fileName + " successfully saved !");
//
//        return filePath.toString();
//    }

    @Override
    public long saveFile(final MultipartFile image) throws IOException {
        Preconditions.checkNotNull(image, "Image can't be null!");
        ImageModel imageModel = new ImageModel();
        imageModel.setImage(image.getBytes());
        imageModel.setFormat(image.getContentType());
        imageRepository.save(imageModel);
        LOG.info("File with id " + imageModel.getId() + " successfully saved !");

        return imageModel.getId();
    }

    @Override
    public long saveFile(final MultipartFile image, final long imageId) throws IOException {
        Preconditions.checkNotNull(image, "Image can't be null!");
        ImageModel imageModel = imageRepository.findById(imageId).get();
        if (Objects.isNull(imageModel)) {
            return saveFile(image);
        }
        imageModel.setImage(image.getBytes());
        imageModel.setFormat(image.getContentType());
        imageRepository.save(imageModel);
        LOG.info("File with id " + imageModel.getId() + " successfully saved !");

        return imageModel.getId();
    }

    @Override
    public ImageModel getImageById(final long imageId) {
        return imageRepository.findById(imageId).get();
    }
}
