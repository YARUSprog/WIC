package com.yarusprog.wic.dto;

public class Share {
    private String pictureOfCompanyUrl;
    private String companyName;
    private Integer allItemsCount;
    private Integer pickedItemsCount;
    private Integer stateOfShare;
    private Boolean isSuccess;
    private Integer errorCode;

    public Share(final String pictureOfCompanyUrl, final String companyName, final Integer allItemsCount, final
    Integer pickedItemsCount, final Integer stateOfShare, final Boolean isSuccess, final Integer errorCode) {
        this.pictureOfCompanyUrl = pictureOfCompanyUrl;
        this.companyName = companyName;
        this.allItemsCount = allItemsCount;
        this.pickedItemsCount = pickedItemsCount;
        this.stateOfShare = stateOfShare;
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }

    public String getPictureOfCompanyUrl() {
        return pictureOfCompanyUrl;
    }

    public void setPictureOfCompanyUrl(final String pictureOfCompanyUrl) {
        this.pictureOfCompanyUrl = pictureOfCompanyUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public Integer getAllItemsCount() {
        return allItemsCount;
    }

    public void setAllItemsCount(final Integer allItemsCount) {
        this.allItemsCount = allItemsCount;
    }

    public Integer getPickedItemsCount() {
        return pickedItemsCount;
    }

    public void setPickedItemsCount(final Integer pickedItemsCount) {
        this.pickedItemsCount = pickedItemsCount;
    }

    public Integer getStateOfShare() {
        return stateOfShare;
    }

    public void setStateOfShare(final Integer stateOfShare) {
        this.stateOfShare = stateOfShare;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(final Boolean success) {
        isSuccess = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final Integer errorCode) {
        this.errorCode = errorCode;
    }
}
