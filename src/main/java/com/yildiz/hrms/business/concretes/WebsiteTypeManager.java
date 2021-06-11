package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.WebsiteTypeService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.WebsiteTypeDao;
import com.yildiz.hrms.entities.concretes.WebsiteType;

@Service
public class WebsiteTypeManager implements WebsiteTypeService {

	private WebsiteTypeDao websiteTypeDao;
	
	@Autowired
	public WebsiteTypeManager(WebsiteTypeDao websiteTypeDao)
	{
		this.websiteTypeDao = websiteTypeDao;
	}

	@Override
	public Result add(WebsiteType websiteType) {
		this.websiteTypeDao.save(websiteType);
		return new SuccessResult(ValidationMessages.WEB_SITE_TYPE_ADD);
	}

	@Override
	public DataResult<List<WebsiteType>> getAll() {
		return new SuccessDataResult<List<WebsiteType>>(ValidationMessages.WEB_SITE_TYPE_GET_ALL_LIST, this.websiteTypeDao.findAll());
	}

	@Override
	public DataResult<WebsiteType> getById(int id) {
		return new SuccessDataResult<WebsiteType>(ValidationMessages.WEB_SITE_TYPE_GET,this.websiteTypeDao.getById(id));
	}
	
	

}