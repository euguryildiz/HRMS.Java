package com.yildiz.hrms.api.controller;

import com.yildiz.hrms.business.abstracts.JobTitleService;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")

public class JobTitlesController {
	
    private JobTitleService jobTitleService;
    @Autowired
    public JobTitlesController(JobTitleService jobTitleService){
        this.jobTitleService=jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll(){
        return jobTitleService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<JobTitle> getById(@RequestParam int id) {
    	return this.jobTitleService.getById(id);
    }
    

    @GetMapping("/getallbyisactive")
    public DataResult<List<JobTitle>> getAllByIsActive(){
        return this.jobTitleService.getAllByIsActive();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
    	return this.jobTitleService.add(jobTitle);
    }
    
   
    
}
