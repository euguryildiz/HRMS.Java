package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Job;
import com.yildiz.hrms.entities.dtos.JobWithEmployerDto;

import org.springframework.data.domain.Sort;


public interface JobService {
	DataResult<List<Job>> getAll();
	Result add(Job job);
	DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetails();
	DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetailsSorted(Sort.Direction sort, String column);
	DataResult<List<JobWithEmployerDto>> getJobWithEmployeCompanyName(String companyName);
	Result setActive(int id, boolean status);
}
