package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeExperienceService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeExperienceDao;
import com.yildiz.hrms.entities.concretes.ResumeExperience;


@Service
public class ResumeExperienceManager implements ResumeExperienceService{

	
	private ResumeExperienceDao resumeExperienceDao;
	
	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao) {
		this.resumeExperienceDao = resumeExperienceDao;
	}
	
	@Override
	public DataResult<List<ResumeExperience>> getAll() {
		return new SuccessDataResult<List<ResumeExperience>>(ValidationMessages.RESUME_EXPERIENCE_GET_ALL_LIST,this.resumeExperienceDao.findAll());
	}

	@Override
	public Result add(ResumeExperience resumeExperience) {
		this.resumeExperienceDao.save(resumeExperience);
		return new SuccessResult(ValidationMessages.RESUME_EXPERIENCE_ADD);
	}

	@Override
	public DataResult<List<ResumeExperience>> getAllSort(Direction sort, String column) {
		Sort sorts = Sort.by(sort,column);
		return new SuccessDataResult<List<ResumeExperience>>(ValidationMessages.RESUME_EXPERIENCE_GET_ALL_LIST, this.resumeExperienceDao.findAll(sorts));
	}

}
