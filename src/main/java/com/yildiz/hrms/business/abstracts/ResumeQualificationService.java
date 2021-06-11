package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeQualification;

public interface ResumeQualificationService {
	DataResult<List<ResumeQualification>> getAll();
	Result add(ResumeQualification resumeQualification);
}
