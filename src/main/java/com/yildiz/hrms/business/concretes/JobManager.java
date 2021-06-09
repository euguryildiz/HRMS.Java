package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.yildiz.hrms.business.abstracts.JobService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.ErrorResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.JobDao;
import com.yildiz.hrms.entities.concretes.Job;
import com.yildiz.hrms.entities.dtos.JobWithEmployerDto;



@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(ValidationMessages.JOB_GET_ALL_LIST,this.jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult(ValidationMessages.JOB_ADD);
	}

	@Override
	public DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetails() {
		return new SuccessDataResult<List<JobWithEmployerDto>>(this.jobDao.getJobWithEmployerDetail());

	}

	@Override
	public DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetailsSorted(Sort.Direction sort, String column) {
		Sort sorts = Sort.by(sort,column);
		return new SuccessDataResult<List<JobWithEmployerDto>>(this.jobDao.getJobWithEmployerDetailSort(sorts));
	}

	@Override
	public DataResult<List<JobWithEmployerDto>> getJobWithEmployeCompanyName(String companyName) {
		return new SuccessDataResult<List<JobWithEmployerDto>>(this.jobDao.getJobWithEmployerBycompanyName(companyName));

	}

	@Override
	public Result setActive(int id, boolean status) {
		Job job = this.jobDao.findById(id).orElse(null);
		if(job != null) {
			job.setActive(status);
			this.jobDao.save(job);
			return new SuccessResult();
		}
		
		return new ErrorResult();

	}


}
