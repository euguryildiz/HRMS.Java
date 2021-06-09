package com.yildiz.hrms.entities.concretes;


import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="user_phones")
@AllArgsConstructor
@NoArgsConstructor
public class UserPhone {
	
	@Id
	@Column(name="user_phone_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@CreatedDate
    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createDate = Instant.now();
	
    @LastModifiedDate
    @JsonIgnore
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();
    
    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
    
    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive = true;
    
    @Column(name="user_id")
    private int userId;
    
    @Column(name = "country_id")
    private int countryId;
    
    @Column(name = "phone")
    private String phone;
    
}
