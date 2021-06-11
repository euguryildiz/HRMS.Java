package com.yildiz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yildiz.hrms.entities.concretes.ResumeWebsite;

public interface ResumeWebsiteDao extends JpaRepository<ResumeWebsite, Integer> {

}
