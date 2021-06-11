package com.yildiz.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yildiz.hrms.business.abstracts.WebsiteTypeService;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.WebsiteType;

@RestController
@RequestMapping("/api/websitetypes")
public class WebsiteTypesController {

	private WebsiteTypeService websiteTypeService;
	
	@Autowired
	public WebsiteTypesController(WebsiteTypeService websiteTypeService) {
		this.websiteTypeService = websiteTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WebsiteType websiteType)
	{
		return websiteTypeService.add(websiteType);
	}
	
	@GetMapping("getall")
	public DataResult<List<WebsiteType>> getAll()
	{
		return this.websiteTypeService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<WebsiteType> getById(@RequestParam int id)
	{
		return this.websiteTypeService.getById(id);
	}
	
	
}
