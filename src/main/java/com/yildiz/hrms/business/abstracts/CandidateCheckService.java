package com.yildiz.hrms.business.abstracts;

import java.util.Date;

public interface CandidateCheckService {
    boolean checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate);
}
