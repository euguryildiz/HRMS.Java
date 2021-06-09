package com.yildiz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yildiz.hrms.entities.concretes.ResumeEducation;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer> {

}
