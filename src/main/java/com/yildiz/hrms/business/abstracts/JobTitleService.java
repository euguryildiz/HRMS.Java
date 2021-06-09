package com.yildiz.hrms.business.abstracts;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.JobTitle;

import java.util.List;



public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    Result add(JobTitle jobTitle);
    DataResult<JobTitle> getById(int id);
    DataResult<List<JobTitle>> getAllByIsActive();
}
