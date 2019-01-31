package com.yarusprog.wic.dto;

import java.util.List;

public class CompanyResponse extends Response {
    private String label;
    private String nameCompany;
    private String shortDescription;
    private List<ContactDto> contacts;
    private String webPage;
    private List<AddressDto> shops;
    private List<ShareForCompanyDto> shares;

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(final String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(final String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(final List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(final String webPage) {
        this.webPage = webPage;
    }

    public List<AddressDto> getShops() {
        return shops;
    }

    public void setShops(final List<AddressDto> shops) {
        this.shops = shops;
    }

    public List<ShareForCompanyDto> getShares() {
        return shares;
    }

    public void setShares(final List<ShareForCompanyDto> shares) {
        this.shares = shares;
    }
}
