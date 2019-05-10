package com.yarusprog.wic.dto;

public class AddressDto {
    private String country;
    private String region;
    private String city;
    private String addressLine;

    public AddressDto(final String country, final String region, final String city, final String adressLine) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.addressLine = adressLine;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(final String adressLine) {
        this.addressLine = adressLine;
    }
}
