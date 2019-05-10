package com.yarusprog.wic.facade;

import com.yarusprog.wic.dto.CompanyResponse;

public interface CompanyFacade {
    CompanyResponse getShares(String login);
}
