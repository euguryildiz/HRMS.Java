package com.yildiz.hrms.core.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
	@Id
	@Column(name = "user_id")
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
    private boolean deleted = false;
    
	@JsonIgnore
    @Column(name = "is_active")
    private boolean active = true;
	
	@NotBlank(message = "Email Boş geçilemez")
	@Length(max = 320, message = "Email maksimum 320 karakter olabilir")
	@Email(message = "Email formata uygun değil")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Şifre boş geçilemez")
	@Length(max = 25, message = "Şifre maksimum 25 karakter olabilir")
	@Column(name = "password")
	private String password;
}
