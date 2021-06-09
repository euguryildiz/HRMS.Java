package com.yildiz.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yildiz.hrms.business.abstracts.ResumeService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeDao;
import com.yildiz.hrms.entities.concretes.Resume;


@Service
public class ResumeManager implements ResumeService {
	
	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}
	
	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult(ValidationMessages.RESUME_ADD);
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(ValidationMessages.RESUME_GET_ALL_LIST,this.resumeDao.findAll());
	}

}
