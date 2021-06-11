package com.yildiz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yildiz.hrms.entities.concretes.ResumeQualification;

public interface ResumeQualificationDao extends JpaRepository<ResumeQualification, Integer> {

}
