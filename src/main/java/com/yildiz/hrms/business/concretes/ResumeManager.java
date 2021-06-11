package com.yildiz.hrms.business.concretes;

import java.io.File;
import java.io.IOException;


import com.cloudinary.utils.ObjectUtils;

import java.util.List;
import java.util.Map;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.yildiz.hrms.business.abstracts.ResumeService;
import com.yildiz.hrms.core.constants.ValidationMessages;
import com.yildiz.hrms.core.utilities.result.DataResult;
import com.yildiz.hrms.core.utilities.result.ErrorResult;
import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessDataResult;
import com.yildiz.hrms.core.utilities.result.SuccessResult;
import com.yildiz.hrms.dataAccess.abstracts.ResumeDao;
import com.yildiz.hrms.entities.concretes.Resume;


@Service
public class ResumeManager implements ResumeService {
	
	
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "duadpqe1p",
			"api_key", "388185829946466",
			"api_secret", "MIJsOyNdX4S4v36iK8ttROq_FuA"));
	
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
	
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.findById(id).orElse(null));
	}

	@Override
	public Result uploadImage(int id, File file) {
		
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> uploadResult = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			JSONObject response=new JSONObject(uploadResult);
			
			Resume resume = getById(id).getData();
			resume.setProfilePictureUrl(response.get("url").toString());
			this.resumeDao.save(resume);
			return new SuccessResult(response.get("url").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ErrorResult();
	}

}
