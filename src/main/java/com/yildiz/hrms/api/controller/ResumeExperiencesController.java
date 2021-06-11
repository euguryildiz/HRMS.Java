package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeExperienceService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeExperience;

@RestController
@RequestMapping("/api/resumeexperience")
public class ResumeExperiencesController {
	
	private ResumeExperienceService resumeExperienceService;
	
	@Autowired
	public ResumeExperiencesController(ResumeExperienceService resumeExperienceService)
	{
		this.resumeExperienceService = resumeExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeExperience resumeExperience)
	{
		return resumeExperienceService.add(resumeExperience);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeExperience>> getAll()
	{
		return resumeExperienceService.getAll();
	}
	
	
	@GetMapping("/getallsort")
	public DataResult<List<ResumeExperience>> getAllSort(Sort.Direction sort, String column)
	{
		return this.resumeExperienceService.getAllSort(sort, column);
	}
	
	
}
