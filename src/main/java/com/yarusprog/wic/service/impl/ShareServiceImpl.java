package com.yarusprog.wic.service.impl;

import com.google.common.base.Preconditions;
import com.yarusprog.wic.model.ShareModel;
import com.yarusprog.wic.repository.ShareRepository;
import com.yarusprog.wic.service.ImageService;
import com.yarusprog.wic.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service("shareService")
public class ShareServiceImpl implements ShareService {

    private static final String PRODUCT_PHOTO_PATH = "product.photo.path";

    private static final Logger LOG = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private ShareRepository shareRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public ShareModel findById(final long id) {
        return shareRepository.findById(id).get();
    }

    @Override
    public ShareModel saveShare(final ShareModel shareModel) {
        return shareRepository.save(shareModel);
    }

//    @Override
//    public ShareModel savePhotoForShareProduct(final MultipartFile photo, final Long shareId) {
//        final String productPhotoDir = env.getProperty(PRODUCT_PHOTO_PATH) + shareId;
//        final ShareModel share = shareRepository.findById(shareId)
//                                          .orElseThrow(() -> new IllegalStateException(
//                                                  "Share with id: " + shareId + " doesn't exist !"));
//        final String productName = share.getProductName();
//        Preconditions.checkNotNull(productName, "Product name can't be null!");
//        final String pathToPhoto = imageService.saveFile(photo, productPhotoDir, productName);
//        share.setProductImageId(pathToPhoto);
//
//        LOG.info("Photo " + pathToPhoto + " successfully set to product of share:  " + shareId);
//
//        return share;
//    }

    @Override
    public ShareModel savePhotoForShareProduct(final MultipartFile photo, final Long shareId) {
        final ShareModel share = shareRepository.findById(shareId)
                                                .orElseThrow(() -> new IllegalStateException(
                                                      "Share with id: " + shareId + " doesn't exist !"));
        try {
            final long imageId;
            if (Objects.isNull(share.getProductImageId())) {
                imageId = imageService.saveFile(photo);
                share.setProductImageId(imageId);
                shareRepository.save(share);
            } else {

                imageId = imageService.saveFile(photo, share.getProductImageId());

            }
            LOG.info("Photo " + imageId + " successfully set to product of share:  " + shareId);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        return share;
    }

}
