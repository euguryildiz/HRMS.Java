package com.yildiz.hrms.api.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
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
	
	@PostMapping("uploadimage/{id}")
	public Result uploadimage(@PathVariable("id") int id, @PathVariable("aFile") MultipartFile aFile)
	{
		File f = new File("");
		try {
			f = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
			aFile.transferTo(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.resumeService.uploadImage(id, f);
	}
	
}
