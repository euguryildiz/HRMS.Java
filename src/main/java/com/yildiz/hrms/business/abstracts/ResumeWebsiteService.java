package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeWebsite;

public interface ResumeWebsiteService {
	Result add(ResumeWebsite resumeWebsite);
	DataResult<List<ResumeWebsite>> getAll();
	DataResult<ResumeWebsite> getById(int id);
}
