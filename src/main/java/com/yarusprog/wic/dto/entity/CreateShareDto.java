package com.yarusprog.wic.dto.entity;

import com.yarusprog.wic.dto.AddressDto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public class CreateShareDto {

    @NotBlank
    private String description;

    @Positive
    private Integer countOfProduct;

    @NotBlank
    private String productName;

    private String linkOnProductUrl;

    private Double productPrice;

    @Positive
    private Integer announcementDuration;

    @Positive
    private Integer shareDuration;

    @Positive
    private Integer afterShareDuration;

    @NotBlank
    private String color;

    @Valid
    @NotNull
    private AddressDto placeAddress;

    @Valid
    @NotEmpty
    private List<ItemDto> items;

    public CreateShareDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(Integer countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLinkOnProductUrl() {
        return linkOnProductUrl;
    }

    public void setLinkOnProductUrl(String linkOnProductUrl) {
        this.linkOnProductUrl = linkOnProductUrl;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getAnnouncementDuration() {
        return announcementDuration;
    }

    public void setAnnouncementDuration(Integer announcementDuration) {
        this.announcementDuration = announcementDuration;
    }

    public Integer getShareDuration() {
        return shareDuration;
    }

    public void setShareDuration(Integer shareDuration) {
        this.shareDuration = shareDuration;
    }

    public Integer getAfterShareDuration() {
        return afterShareDuration;
    }

    public void setAfterShareDuration(Integer afterShareDuration) {
        this.afterShareDuration = afterShareDuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AddressDto getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(AddressDto placeAddress) {
        this.placeAddress = placeAddress;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
