package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.EmployerService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.business.CheckEngine.CheckEngine;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.ErrorResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.EmployerDao;
import com.yildiz.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(ValidationMessages.EMPLOYER_GET_ALL_LIST,this.employerDao.findAll());
	}
	
	@Override
	public Result add(Employer employer) {
		
		Result result = CheckEngine.run(
				CheckIfExistsByEmail(employer),
				CheckIfEmailDomainControl(employer)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.employerDao.save(employer);
		return new SuccessResult(ValidationMessages.EMPLOYER_ADD);
	}
	
	
	
	private Result CheckIfExistsByEmail(Employer employer)
	{
		boolean result  = this.employerDao.existsByEmailAndIdNot(employer.getEmail(),employer.getId());
		
		if(result) {
			return new ErrorResult(ValidationMessages.EMPLOYER_EMAİL_EMAIL_ALREADY);
		}
		
		return new SuccessResult();		
	}
	
	private Result CheckIfEmailDomainControl(Employer employer)
	{
		String[] emailSplit = employer.getEmail().split("@");
		if (!employer.getWebsite().contains(emailSplit[1])) {
		return new ErrorResult(ValidationMessages.EMPLOYER_MAIL_NOT_MATCH);
		}
	
		return new SuccessResult();
	}


}
