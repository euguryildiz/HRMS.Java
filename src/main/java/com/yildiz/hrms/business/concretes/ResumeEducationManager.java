package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeEducationService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeEducationDao;
import com.yildiz.hrms.entities.concretes.ResumeEducation;

@Service
public class ResumeEducationManager implements ResumeEducationService {

	
	private ResumeEducationDao resumeEducationDao; 
	
	
	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao) {
		this.resumeEducationDao = resumeEducationDao;
	}
	
	@Override
	public Result add(ResumeEducation resumeEducation) {
		this.resumeEducationDao.save(resumeEducation);
		return new SuccessResult(ValidationMessages.RESUME_EDUCATION_ADD);
	}

	@Override
	public DataResult<List<ResumeEducation>> getAll() {
		return new SuccessDataResult<List<ResumeEducation>>(ValidationMessages.RESUME_EDUCATION_GET_ALL_LIST,this.resumeEducationDao.findAll());
	}



}
