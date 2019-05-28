package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.CreateShareDto;
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

    public ShareModel convertToModel(final CreateShareDto source) {
        final ShareModel shareModel = new ShareModel();
        modelMapper.map(source, shareModel);
        return shareModel;
    }

    private CreateShareDto convertToDto(final ShareModel source) {
        final CreateShareDto shareDto = new CreateShareDto();
        modelMapper.map(source, shareDto);
        return shareDto;
    }
}
