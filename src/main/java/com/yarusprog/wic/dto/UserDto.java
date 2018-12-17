package com.yarusprog.wic.dto;

public class UserDto {
    private String login;
    private Integer countOfVins;
    private String name;

    public UserDto() {
    }

    public UserDto(final String login, final Integer countOfVins, final String name) {
        this.login = login;
        this.countOfVins = countOfVins;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public Integer getCountOfVins() {
        return countOfVins;
    }

    public void setCountOfVins(final Integer countOfVins) {
        this.countOfVins = countOfVins;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
