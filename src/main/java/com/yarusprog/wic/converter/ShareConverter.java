package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.model.ShareModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShareConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemConverter itemConverter;

    public ShareModel convertToModel(final ShareDto source) {
        final ShareModel shareModel = new ShareModel();
        modelMapper.map(source, shareModel);
        return shareModel;
    }

    public ShareDto convertToDto(final ShareModel source) {
        final ShareDto shareDto = new ShareDto();
        modelMapper.map(source, shareDto);
        return shareDto;
    }
}
