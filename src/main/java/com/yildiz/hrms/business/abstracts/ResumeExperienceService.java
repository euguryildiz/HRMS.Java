package com.yildiz.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeExperience;

public interface ResumeExperienceService {
	
	DataResult<List<ResumeExperience>> getAll();
	Result add(ResumeExperience resumeExperience);
	DataResult<List<ResumeExperience>> getAllSort(Sort.Direction sort, String column);


}
