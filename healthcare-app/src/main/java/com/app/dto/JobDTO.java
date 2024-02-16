package com.app.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.dao.JobDao;
import com.app.entities.Doctor;
import com.app.entities.Hospital;
import com.app.entities.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobDTO {
	
	String title;
	String description;
	Specialization specialization;
	double price;
	
    private Long hospitalId;
    LocalDate date;
	Double duration;

    private Set<Doctor> doctorsApplied = new HashSet<>();

	private Set<Doctor> doctorsAccepted = new HashSet<>();

	private Integer openPositions;
}
