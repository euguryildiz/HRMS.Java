package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeLanguageService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeLanguageDao;
import com.yildiz.hrms.entities.concretes.ResumeLanguage;

@Service
public class ResumeLanguageManager implements ResumeLanguageService {

	private ResumeLanguageDao resumeLanguageDao;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao)
	{
		this.resumeLanguageDao = resumeLanguageDao;
	}
	
	@Override
	public Result add(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		return new SuccessResult(ValidationMessages.RESUME_LANGUAGE_ADD);
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccessDataResult<List<ResumeLanguage>>(ValidationMessages.RESUME_LANGUAGE_GET_ALL_LIST,this.resumeLanguageDao.findAll());
	}



}
