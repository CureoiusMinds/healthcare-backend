package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HospitalSignup {
	
	
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	String name;
	
	String location;
	
	Specialization specialization;
}
