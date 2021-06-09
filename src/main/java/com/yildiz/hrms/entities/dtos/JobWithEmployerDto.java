package com.yildiz.hrms.entities.dtos;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobWithEmployerDto {
	
	private int id;
	private String companyName;
	private String jobTitle;
	private BigDecimal applicantQuota;
	private Instant createDate;
	private Instant lastApplicationDate; 

}
