package com.yarusprog.wic.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.yarusprog.wic.model.ShareState;

public class CreateShareDto {

    @Email
    @NotBlank
    private String login;

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

    @Valid
    @NotEmpty
    private List<CreateItemDto> items;

    public CreateShareDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(final String shareName) {
        this.shareName = shareName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(final Integer countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public String getPhotoProductUrl() {
        return photoProductUrl;
    }

    public void setPhotoProductUrl(final String photoProductUrl) {
        this.photoProductUrl = photoProductUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public String getLinkOnProductUrl() {
        return linkOnProductUrl;
    }

    public void setLinkOnProductUrl(final String linkOnProductUrl) {
        this.linkOnProductUrl = linkOnProductUrl;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(final Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getAnnouncementDuration() {
        return announcementDuration;
    }

    public void setAnnouncementDuration(final Integer announcementDuration) {
        this.announcementDuration = announcementDuration;
    }

    public Integer getShareDuration() {
        return shareDuration;
    }

    public void setShareDuration(final Integer shareDuration) {
        this.shareDuration = shareDuration;
    }

    public Integer getAfterShareDuration() {
        return afterShareDuration;
    }

    public void setAfterShareDuration(final Integer afterShareDuration) {
        this.afterShareDuration = afterShareDuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public Integer getPickedItemsCount() {
        return pickedItemsCount;
    }

    public void setPickedItemsCount(final Integer pickedItemsCount) {
        this.pickedItemsCount = pickedItemsCount;
    }

    public Integer getAllItemsCount() {
        return allItemsCount;
    }

    public void setAllItemsCount(final Integer allItemsCount) {
        this.allItemsCount = allItemsCount;
    }

    public String getCodeForWinner() {
        return codeForWinner;
    }

    public void setCodeForWinner(final String codeForWinner) {
        this.codeForWinner = codeForWinner;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(final Timestamp date) {
        this.date = date;
    }

    public ShareState getStatus() {
        return status;
    }

    public void setStatus(final ShareState status) {
        this.status = status;
    }

    public List<CreateItemDto> getItems() {
        return items;
    }

    public void setItems(final List<CreateItemDto> items) {
        this.items = items;
    }
}
