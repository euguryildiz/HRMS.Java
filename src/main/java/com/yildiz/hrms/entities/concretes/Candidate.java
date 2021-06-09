package com.yildiz.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.yildiz.hrms.core.entities.User;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User{
	
    @NotBlank(message="firs name is a required field")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message="last name is a required field")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message="identity number is a required field")
    @Column(name = "identity_number")
    
    
    private String identityNumber;
    @NotNull(message="birth date is a required field")
    @Column(name = "birth_date")
    private Date birthDate;
}
