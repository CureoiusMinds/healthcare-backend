package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Specialization;

public class HospitalDTO {

	String name;
	
	String location;
	
	Specialization specialization;
}
