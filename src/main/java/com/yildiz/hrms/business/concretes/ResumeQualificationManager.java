package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeQualificationService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeQualificationDao;
import com.yildiz.hrms.entities.concretes.ResumeQualification;

@Service
public class ResumeQualificationManager implements ResumeQualificationService{

	private ResumeQualificationDao resumeQualificationDao;
	
	@Autowired
	public ResumeQualificationManager(ResumeQualificationDao resumeQualificationDao) {
		this.resumeQualificationDao = resumeQualificationDao;
	}
	
	@Override
	public DataResult<List<ResumeQualification>> getAll() {
		return new SuccessDataResult<List<ResumeQualification>>(ValidationMessages.RESUME_QUALIFICATION_GET_ALL_LIST, this.resumeQualificationDao.findAll());
	}

	@Override
	public Result add(ResumeQualification resumeQualification) {
		this.resumeQualificationDao.save(resumeQualification);
		return new SuccessResult(ValidationMessages.RESUME_QUALIFICATION_ADD);
	}

}
