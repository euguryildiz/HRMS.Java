package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeWebsiteService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeWebsiteDao;
import com.yildiz.hrms.entities.concretes.ResumeWebsite;

@Service
public class ResumeWebsiteManager implements ResumeWebsiteService {

	private ResumeWebsiteDao resumeWebsiteDao;
	
	@Autowired
	public ResumeWebsiteManager(ResumeWebsiteDao resumeWebsiteDao) {
		this.resumeWebsiteDao = resumeWebsiteDao;
	}
	
	@Override
	public Result add(ResumeWebsite resumeWebsite) {
		this.resumeWebsiteDao.save(resumeWebsite);
		return new SuccessResult(ValidationMessages.RESUME_WEBSITE_ADD);
	}

	@Override
	public DataResult<List<ResumeWebsite>> getAll() {
		return new SuccessDataResult<List<ResumeWebsite>>(ValidationMessages.RESUME_WEBSITE_GET_ALL_LIST, this.resumeWebsiteDao.findAll());
	}

	@Override
	public DataResult<ResumeWebsite> getById(int id) {
		return new SuccessDataResult<ResumeWebsite>(ValidationMessages.RESUME_WEBSITE_GET, this.resumeWebsiteDao.getById(id));
	}

}
