package com.yarusprog.wic.dto.entity;

import com.yarusprog.wic.model.ShareState;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.List;

public class ShareDto {

    @Null
    private Long id;

    @NotBlank
    private String shareName;

    @NotBlank
    private String description;

    @Positive
    private Integer countOfProduct;

    @NotBlank
    private String photoProductUrl;

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

    @Positive
    private Integer pickedItemsCount;

    @Positive
    private Integer allItemsCount;

    @NotBlank
    private String codeForWinner;

    @FutureOrPresent
    private Timestamp date;

    @Null
    private ShareState status;

    @Null
    private Integer companyId;

    @Valid
    @NotEmpty
    private List<ItemDto> items;

    public ShareDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
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

    public String getPhotoProductUrl() {
        return photoProductUrl;
    }

    public void setPhotoProductUrl(String photoProductUrl) {
        this.photoProductUrl = photoProductUrl;
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

    public Integer getPickedItemsCount() {
        return pickedItemsCount;
    }

    public void setPickedItemsCount(Integer pickedItemsCount) {
        this.pickedItemsCount = pickedItemsCount;
    }

    public Integer getAllItemsCount() {
        return allItemsCount;
    }

    public void setAllItemsCount(Integer allItemsCount) {
        this.allItemsCount = allItemsCount;
    }

    public String getCodeForWinner() {
        return codeForWinner;
    }

    public void setCodeForWinner(String codeForWinner) {
        this.codeForWinner = codeForWinner;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public ShareState getStatus() {
        return status;
    }

    public void setStatus(ShareState status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
