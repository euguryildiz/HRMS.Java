package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.QualificationService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.QualificationDao;
import com.yildiz.hrms.entities.concretes.Qualification;

@Service
public class QualificationManager implements QualificationService {

	private QualificationDao qualificationDao;
	
	@Autowired
	public QualificationManager(QualificationDao qualificationDao) {
		this.qualificationDao = qualificationDao;
	}
	
	@Override
	public Result add(Qualification qualification) {
		this.qualificationDao.save(qualification);
		return new SuccessResult(ValidationMessages.QUALIFICATON_ADD);
	}

	@Override
	public DataResult<List<Qualification>> getAll() {	
		return new SuccessDataResult<List<Qualification>>(ValidationMessages.QUALIFICATON_GET_ALL_LIST, this.qualificationDao.findAll());
	}

	
	
}
