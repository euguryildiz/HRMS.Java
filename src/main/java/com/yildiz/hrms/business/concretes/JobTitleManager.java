package com.yildiz.hrms.business.concretes;

import com.yildiz.hrms.business.abstracts.JobTitleService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.business.CheckEngine.CheckEngine;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.ErrorResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.JobTitleDao;
import com.yildiz.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired//To Activate DependencyIncetion IOC Container
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>("Job title get all list",this.jobTitleDao.findAll());
    }

    @Override
    public Result add(JobTitle jobTitle) {
    	
		Result result = CheckEngine.run(
				CheckIfExistsByTitle(jobTitle)
				);
		
		if(!result.isSuccess()) {
			return result;
		}
    	
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult();
    }

    @Override
    public DataResult<JobTitle> getById(int id) {
    	return new SuccessDataResult<JobTitle>(this.jobTitleDao.findById(id).get());
    }

    
    @Override
    public DataResult<List<JobTitle>> getAllByIsActive() {
        return new SuccessDataResult<List<JobTitle>>("Active job title all list",this.jobTitleDao.findAllByIsActiveTrueAndIsDeletedFalse());
    }
    
    
    private Result CheckIfExistsByTitle(JobTitle jobTitle)
    {
		boolean result  = this.jobTitleDao.existsByTitleAndIdNot(jobTitle.getTitle(),jobTitle.getId());
		
		if(result) {
			return new ErrorResult(ValidationMessages.JOBTITLE_TITLE_ALREADY);
		}
		
		return new SuccessResult();		
    }

    
}
