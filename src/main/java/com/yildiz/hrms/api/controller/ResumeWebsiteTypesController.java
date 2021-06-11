package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeWebsiteService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeWebsite;

@RestController
@RequestMapping("/api/resumewebsitetypes")
public class ResumeWebsiteTypesController {

	private ResumeWebsiteService resumeWebsiteService;
	
	@Autowired
	public ResumeWebsiteTypesController(ResumeWebsiteService resumeWebsiteService) {
		this.resumeWebsiteService = resumeWebsiteService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeWebsite resumeWebsite) {
		return this.resumeWebsiteService.add(resumeWebsite);
	}
	
	@GetMapping("getall")
	public DataResult<List<ResumeWebsite>> getAll()
	{
		return this.resumeWebsiteService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<ResumeWebsite> getById(@RequestParam int id)
	{
		return this.resumeWebsiteService.getById(id);
	}
	
}
