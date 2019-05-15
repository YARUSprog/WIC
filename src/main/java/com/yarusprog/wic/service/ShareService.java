package com.yarusprog.wic.service;

import com.yarusprog.wic.model.ShareModel;

public interface ShareService {
    ShareModel findById(long id);
    ShareModel saveShare(ShareModel shareModel);
}
