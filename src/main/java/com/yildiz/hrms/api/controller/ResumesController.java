package com.yildiz.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeService;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

	private ResumeService resumeService;
	
	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume)
	{
		return this.resumeService.add(resume);
	}
	
	
}
