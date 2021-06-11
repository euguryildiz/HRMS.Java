package com.yildiz.hrms.entities.concretes;

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
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_websites")
public class ResumeWebsite extends BaseEntityMini {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_website_id")
	private int id;
	
	@Column(name = "resume_id")
	private int resumeId;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "website_type_id")
	private int website_type_id;
	
	
	@ManyToOne(targetEntity = Resume.class ,fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume;
	
	@ManyToOne(targetEntity = WebsiteType.class, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "website_type_id", insertable = false, updatable = false)
	private WebsiteType websiteType;
	
}
