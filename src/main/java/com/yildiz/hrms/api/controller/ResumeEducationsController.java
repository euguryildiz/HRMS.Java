package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeEducationService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeEducation;

@RestController
@RequestMapping("/api/resumeeducations")
public class ResumeEducationsController {

	private ResumeEducationService resumeEducationService;
	
	@Autowired
	public ResumeEducationsController(ResumeEducationService resumeEducationService)
	{
		this.resumeEducationService = resumeEducationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducation resumeEducation)
	{
		return this.resumeEducationService.add(resumeEducation);
	}
	
	@GetMapping("/getall")
	public  DataResult<List<ResumeEducation>> getAll()
	{
		return this.resumeEducationService.getAll();
	}
	
	
}

