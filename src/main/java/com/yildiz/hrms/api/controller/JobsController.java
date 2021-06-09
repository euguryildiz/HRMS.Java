package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.JobService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Job;
import com.yildiz.hrms.entities.dtos.JobWithEmployerDto;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getall(){
		return this.jobService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	@GetMapping("/getJobWithEmployerDetails")
	DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetails(){
		return this.jobService.getJobWithEmployerDetails();
	}
	
	@GetMapping("/getJobWithEmployerDetailsSorted")
	DataResult<List<JobWithEmployerDto>> getJobWithEmployerDetailsSorted(Sort.Direction sort, String column){
		return this.jobService.getJobWithEmployerDetailsSorted(sort, column);
	}
	
	@GetMapping("/getJobWithEmployeCompanyName")
	DataResult<List<JobWithEmployerDto>> getJobWithEmployeCompanyName(String companyName){
		return this.jobService.getJobWithEmployeCompanyName(companyName);
	}
	
	
}
