package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Qualification;

public interface QualificationService {
	
	Result add(Qualification qualification);
	DataResult<List<Qualification>> getAll();
}
