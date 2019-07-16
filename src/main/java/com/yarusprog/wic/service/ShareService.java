package com.yarusprog.wic.service;

import com.yarusprog.wic.model.ShareModel;
import org.springframework.web.multipart.MultipartFile;

public interface ShareService {
    ShareModel findById(long id);
    ShareModel saveShare(ShareModel shareModel);
    ShareModel savePhotoForShareProduct(MultipartFile photo, Long shareId);
}
