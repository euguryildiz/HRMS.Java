package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.WebsiteType;

public interface WebsiteTypeService {

	Result add(WebsiteType websiteType);
	DataResult<List<WebsiteType>> getAll();
	DataResult<WebsiteType> getById(int id);
	
}
