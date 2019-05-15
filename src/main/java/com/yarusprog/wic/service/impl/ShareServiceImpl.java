package com.yarusprog.wic.service.impl;

import com.yarusprog.wic.model.ShareModel;
import com.yarusprog.wic.repository.ShareRepository;
import com.yarusprog.wic.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shareService")
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Override
    public ShareModel findById(final long id) {
        return shareRepository.findById(id).get();
    }

    @Override
    public ShareModel saveShare(final ShareModel shareModel) {
        return shareRepository.save(shareModel);
    }
}
