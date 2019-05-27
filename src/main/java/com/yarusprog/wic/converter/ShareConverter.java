package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.model.ShareModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

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

    private ShareDto convertToDto(final ShareModel source) {
        final ShareDto shareDto = new ShareDto();
        modelMapper.map(source, shareDto);
        return shareDto;
    }
}
