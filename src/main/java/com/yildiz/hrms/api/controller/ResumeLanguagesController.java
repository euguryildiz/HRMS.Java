package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.ResumeLanguageService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/resumelanguages")
public class ResumeLanguagesController {

	private ResumeLanguageService resumeLanguageService;
	
	public ResumeLanguagesController(ResumeLanguageService resumeLanguageService)
	{
		this.resumeLanguageService = resumeLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeLanguage resumeLanguage)
	{
		return resumeLanguageService.add(resumeLanguage);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ResumeLanguage>> getall(){
		return resumeLanguageService.getAll();
	}
	
}
