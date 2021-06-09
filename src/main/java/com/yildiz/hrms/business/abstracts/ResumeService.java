package com.yildiz.hrms.business.abstracts;

import java.util.List;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Resume;

public interface ResumeService {

	Result add(Resume resume);
	DataResult<List<Resume>> getAll();
}
