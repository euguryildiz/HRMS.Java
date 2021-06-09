package com.yildiz.hrms.business.adapter;

import com.yildiz.hrms.business.abstracts.IdentityValidationService;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;

@Service
public class MernisAdapterManager implements IdentityValidationService {
    @Override
    public boolean checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate) {
        Long identity = Long.parseLong(identityNumber);
        int year = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();

        KPSPublicSoapProxy ishkpsPublicSoap=new KPSPublicSoapProxy();

        try {
            return ishkpsPublicSoap.TCKimlikNoDogrula(identity,firstName,lastName,year);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
