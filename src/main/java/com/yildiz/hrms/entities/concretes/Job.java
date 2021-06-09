package com.yildiz.hrms.entities.concretes;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yildiz.hrms.core.entities.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobs")
public class Job extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private int id;
	
	@NotBlank
	@Column(name = "title")
	private String title;
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
	@NotBlank
	@Column(name = "job_title_id")
	private int jobTitleId;
	
	@NotBlank
	@Column(name = "state_id")
	private int stateId;
	
	
	@Column(name = "min_salary")
	private BigDecimal minSalary;
	
	@Column(name = "max_salary")
	private BigDecimal maxSalary;
	
	@NotBlank
	@Column(name = "applicant_quota")
	private BigDecimal applicantQuota;
	
	@NotBlank
	@Column(name = "last_application_date")
	private Instant lastApplicationDate; 
	
	@ManyToOne(targetEntity = State.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", insertable = false, updatable = false)
	@JsonIgnore
	private State state;
	
	@ManyToOne(targetEntity = JobTitle.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id", insertable = false, updatable = false)
	@JsonIgnore
	private JobTitle jobTitle;
	
	@ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_user_id", insertable = false, updatable = false)
	@JsonIgnore
	private Employer employer;

	
	
}
