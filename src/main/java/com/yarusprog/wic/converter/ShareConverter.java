package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.model.ShareModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ShareConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ShareModel convertToModel(final ShareDto source) {
        if(Objects.nonNull(source)) {
            final ShareModel shareModel = new ShareModel();
            modelMapper.map(source, shareModel);
            return shareModel;
        }
        return null;
    }

    private ShareDto convertToDto(final ShareModel source) {
        if(Objects.nonNull(source)) {
            final ShareDto shareDto = new ShareDto();
            modelMapper.map(source, shareDto);
            return shareDto;
        }
        return null;
    }
}
