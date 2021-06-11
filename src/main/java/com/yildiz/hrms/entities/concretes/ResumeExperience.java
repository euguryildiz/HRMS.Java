package com.yildiz.hrms.entities.concretes;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yildiz.hrms.core.entities.BaseEntityMini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resume_experiences")
public class ResumeExperience extends BaseEntityMini {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_experience_id")
	private int id;
	
	@NotBlank
	@Column(name = "resume_id")
	private int resumeId;
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "job_title_id")
	private int jobTitleId;
	
	@Column(name = "start_date")
	private Instant startDate;
	
	@Column(name = "is_continued")
	private boolean isContinued;
	
	@Column(name = "end_date")
	private Instant endDate;
	
	
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	@JsonIgnore
	private Resume resume;
	
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id", insertable = false, updatable = false)
	@JsonIgnore
	private JobTitle jobTitle;
	
}
