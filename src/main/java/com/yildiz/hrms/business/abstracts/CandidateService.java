package com.yildiz.hrms.business.abstracts;

import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
	Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();
}
