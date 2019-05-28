package com.yarusprog.wic.dto;

import javax.validation.constraints.NotNull;

public class CreateItemDto {

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    public CreateItemDto() {
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }
}
