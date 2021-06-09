package com.yildiz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.yildiz.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
	
    List<JobTitle> findAllByIsActiveTrueAndIsDeletedFalse();
    
    boolean existsByTitleAndIdNot(@Param("title") String title, @Param("id") int id);
    

}
