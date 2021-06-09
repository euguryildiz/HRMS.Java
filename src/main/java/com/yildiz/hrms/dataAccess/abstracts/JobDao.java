package com.yildiz.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yildiz.hrms.entities.concretes.Job;
import com.yildiz.hrms.entities.dtos.JobWithEmployerDto;

public interface JobDao extends JpaRepository<Job, Integer>{

	
	@Query(Query_JobWithEmployerDto)
	List<JobWithEmployerDto> getJobWithEmployerDetail();
	
	
	@Query(Query_JobWithEmployerDto)
	List<JobWithEmployerDto> getJobWithEmployerDetailSort(Sort sort);
	
	
	@Query(Query_JobWithEmployerDtoByCompanyName)
	List<JobWithEmployerDto> getJobWithEmployerBycompanyName(@Param("companyName") String companyName);
	
	
	
	String Query_JobWithEmployerDto = 
			"SELECT new com.yildiz.hrms.entities.dtos.JobWithEmployerDto "
			+ "(j.id, e.companyName, t.title, j.applicantQuota, j.createDate, j.lastApplicationDate) "
			+ "FROM Job j "
			+ "JOIN j.jobTitle t "
			+ "JOIN j.employer e "
			+ "Where j.isActive = true ";
	
	String Query_JobWithEmployerDtoByCompanyName = 
			"SELECT new com.yildiz.hrms.entities.dtos.JobWithEmployerDto "
			+ "(j.id, e.companyName, t.title, j.applicantQuota, j.createDate, j.lastApplicationDate) "
			+ "FROM Job j "
			+ "JOIN j.jobTitle t "
			+ "JOIN j.employer e "
			+ "Where j.isActive = true AND lower(e.companyName) like CONCAT('%',lower(:companyName),'%')";


}
