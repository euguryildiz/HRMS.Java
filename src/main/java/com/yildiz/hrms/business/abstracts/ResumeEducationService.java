package com.yildiz.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeEducation;

public interface ResumeEducationService {
	
	Result add(ResumeEducation resumeEducation);
	DataResult<List<ResumeEducation>> getAll();
	DataResult<List<ResumeEducation>> getAllSort(Sort.Direction sort, String column);
	
}
