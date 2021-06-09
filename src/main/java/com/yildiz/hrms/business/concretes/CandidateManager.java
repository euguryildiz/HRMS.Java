package com.yildiz.hrms.business.concretes;

import com.yildiz.hrms.business.abstracts.CandidateCheckService;
import com.yildiz.hrms.business.abstracts.CandidateService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.business.CheckEngine.CheckEngine;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.ErrorResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.CandidateDao;
import com.yildiz.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private CandidateCheckService candidateCheckService;


    @Autowired
    public CandidateManager(CandidateDao candidateDao,CandidateCheckService candidateCheckService)
    {
        this.candidateDao = candidateDao;
        this.candidateCheckService=candidateCheckService;
    }

    @Override
    public Result add(Candidate candidate) {
       
		Result result = CheckEngine.run(
				CheckIfEmailAlreadyExists(candidate),
				CheckIfIdentityControl(candidate)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult(ValidationMessages.CANDIDATE_ADD);

    }

    @Override
    public DataResult<List<Candidate>> getAll() {
            return new SuccessDataResult<List<Candidate>>(ValidationMessages.CANDIDATE_GET_ALL_LIST,this.candidateDao.findAll()); 
    }
    
    
    
    
    private Result CheckIfIdentityControl(Candidate candidate) {
    	if(!this.candidateCheckService.checkIdentityNumber(candidate.getIdentityNumber(),candidate.getFirstName(),candidate.getLastName(),candidate.getBirthDate()))
        {
           return new ErrorResult(ValidationMessages.CANDIDATE_NOT_FOUND_IDENTIY);
        }
    	
    	return new SuccessResult();
    }
    
    private Result CheckIfEmailAlreadyExists(Candidate candidate) {
		
		boolean result = this.candidateDao.existsByEmailAndIdNot(candidate.getEmail(),candidate.getId());
		
		if(result) {
			return new ErrorResult(ValidationMessages.CANDIDATE_EMAİL_EMAIL_ALREADY);
		}
		
		return new SuccessResult();
	}
    
    
}
