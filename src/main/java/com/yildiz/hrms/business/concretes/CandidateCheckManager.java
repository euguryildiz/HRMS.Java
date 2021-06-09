package com.yildiz.hrms.business.concretes;

import com.yildiz.hrms.business.abstracts.CandidateCheckService;
import com.yildiz.hrms.business.abstracts.IdentityValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class CandidateCheckManager implements CandidateCheckService {

    private IdentityValidationService identityValidationService;
    @Autowired
    public CandidateCheckManager(IdentityValidationService identityValidationService){
        this.identityValidationService=identityValidationService;
    }
    @Override
    public boolean checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate) {
        return this.identityValidationService.checkIdentityNumber(identityNumber,firstName,lastName,birthDate);
    }


    
    
}
