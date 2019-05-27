package com.yarusprog.wic.converter;

import com.yarusprog.wic.dto.entity.ItemDto;
import com.yarusprog.wic.dto.entity.ShareDto;
import com.yarusprog.wic.model.ItemModel;
import com.yarusprog.wic.model.ShareModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ItemModel convertToModel(final ItemDto source) {
        final ItemModel itemModel = new ItemModel();
        modelMapper.map(source, itemModel);
        return itemModel;
    }

    private ItemDto convertToDto(final ItemModel source) {
        final ItemDto itemDto = new ItemDto();
        modelMapper.map(source, itemDto);
        return itemDto;
    }
}
