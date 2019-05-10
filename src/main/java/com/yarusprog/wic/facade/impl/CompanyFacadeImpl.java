package com.yarusprog.wic.facade.impl;

import java.util.Arrays;
import java.util.Date;

import com.yarusprog.wic.dto.AddressDto;
import com.yarusprog.wic.dto.CompanyResponse;
import com.yarusprog.wic.dto.ShareForCompanyDto;
import com.yarusprog.wic.facade.CompanyFacade;
import com.yarusprog.wic.facade.UserFacade;
import com.yarusprog.wic.model.ShareState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyFacadeImpl implements CompanyFacade {

    @Autowired
    private UserFacade userFacade;

    @Override
    public CompanyResponse getShares(final String login) {
        return getUserProfileTestData(UserFacadeImpl.isLoginValid(login));
    }

    private CompanyResponse getUserProfileTestData(final Boolean valid) {
        CompanyResponse userProfileResponse = new CompanyResponse();
        if (valid) {
            ShareForCompanyDto cocaColaShare = new ShareForCompanyDto("cocacola_0_1", new Date(),"/images/cocacola-logo.png",  23,
                    0, ShareState.SOON.ordinal());
            ShareForCompanyDto cocaColaShare2 = new ShareForCompanyDto("cocacola_0_2", new Date(),"/images/cocacola-logo.png",  44,
                    0, ShareState.COMPLETED.ordinal());

            AddressDto address1 = new AddressDto("Ukraine", "Kiev reg", "Kiev", "Shevchenka 20");
            AddressDto address2 = new AddressDto("Ukraine", "Kiev reg", "Kiev", "Lenina 3/5, room 5");

            userProfileResponse.setShares(Arrays.asList(cocaColaShare, cocaColaShare2));
            userProfileResponse.setContacts(userFacade.getUserContacts().get("user@gmail.com"));
            userProfileResponse.setLabel("/images/cocacola-logo.png");
            userProfileResponse.setNameCompany("Macdonalds");
            userProfileResponse.setShortDescription("Fast food");
            userProfileResponse.setWebPage("https://mcdonalds.by/ru/");
            userProfileResponse.setShops(Arrays.asList(address1, address2));

            userProfileResponse.setSuccess(true);
            userProfileResponse.setErrorCode(0);
        } else {
            userProfileResponse.setSuccess(false);
            userProfileResponse.setErrorCode(1);
        }
        return userProfileResponse;
    }

}
