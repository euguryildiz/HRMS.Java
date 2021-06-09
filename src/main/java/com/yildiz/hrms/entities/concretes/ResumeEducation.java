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
@Table(name="resume_educations")
public class ResumeEducation extends BaseEntityMini {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_education_id")
	private int id;
	
	@Column(name = "resume_id")
	private int resumeId;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "start_date")
	private Instant startDate;
	
	@Column(name = "is_graduate")
	private boolean isGraduate;
	
	@Column(name = "graduate_date")
	private Instant graduateDate;
	
	
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	@JsonIgnore
	private Resume resume;
	

}
