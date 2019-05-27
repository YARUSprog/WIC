package com.yarusprog.wic.dto.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class ItemDto {

    @Null
    private Long id;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @Null
    private Long shareId;

    public ItemDto() {
    }

    public ItemDto(Long id, Double longitude, Double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }
}
