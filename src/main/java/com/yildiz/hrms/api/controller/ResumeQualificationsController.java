package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeQualificationService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeQualification;

@RestController
@RequestMapping("/api/resumequalifications")
public class ResumeQualificationsController {

	private ResumeQualificationService resumeQualificationService;
	
	@Autowired
	public ResumeQualificationsController(ResumeQualificationService resumeQualificationService)
	{
		this.resumeQualificationService = resumeQualificationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeQualification resumeQualification)
	{
		return resumeQualificationService.add(resumeQualification);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeQualification>> getAll()
	{
		return resumeQualificationService.getAll();
	}
	
	
}
