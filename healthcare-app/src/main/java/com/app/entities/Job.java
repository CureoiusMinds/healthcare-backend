package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Job")
public class Job {
	
	@Column(length = 100)
	String title;
	@Column(length = 100)
	String description;
	@Enumerated(EnumType.STRING)
	Specialization specialization;
	@Column(length = 100)
	double price;
	
	
	
	@ManyToOne
    private Hospital hospital;
	
	
	@ManyToMany
    @JoinTable(
            name = "job_doctor",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors = new HashSet<>();
	
}
