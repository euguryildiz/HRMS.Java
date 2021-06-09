package com.yildiz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import com.yildiz.hrms.core.entities.BaseEntity;


@Data//GETTER SETTER
@Entity//Entity
@AllArgsConstructor//WITH PARAM CONST
@NoArgsConstructor//WITHOUT PARAM CONST
@EqualsAndHashCode(callSuper=false)
@Table(name="job_titles")//Table
public class JobTitle extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_title_id")
	private int id;
	
	@Column(name = "title")
	@NotBlank(message = "Boş Geçilemez")
	private String title;
	
	

}
