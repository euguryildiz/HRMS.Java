package com.yildiz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yildiz.hrms.entities.concretes.Qualification;

public interface QualificationDao extends JpaRepository<Qualification, Integer>{

}
