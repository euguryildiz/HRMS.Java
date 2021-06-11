package com.yildiz.hrms.entities.concretes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yildiz.hrms.core.entities.BaseEntityMini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_languages")
public class ResumeLanguage extends BaseEntityMini{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_language_id")
	private int id;
	
	@Column(name = "resume_id")
	private int resumeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "grade")
	private BigDecimal grade;
	
	
	@ManyToOne(targetEntity = Resume.class ,fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", insertable = false, updatable = false) 
	private Resume resume;
	
	
}
