package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorSignup {
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	@Column(length = 14)
	private String mobileNo;
	@Column
	private LocalDate DoB;
	@Column
	private Integer yearsOfEx;
	@Column(length = 30)
	private String underGrad;
	@Column(length = 30)
	private String postGrad;
	@Column(length = 100)
	private String otherQualifications;
	@Column(length = 100)
	private String prevEmployment;
	@Column(length = 100)
	private String bioNote;
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;
	@Column(length = 50)
	private String medicalLicenseId;
	@Column
	@Enumerated(value = EnumType.STRING)
	Specialization specialization;
	
	
}
