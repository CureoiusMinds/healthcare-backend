package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Job")
public class Job extends BaseEntity{
	
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
            name = "job_doctors_applied",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctorsApplied = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "job_doctors_accepted",
			joinColumns = @JoinColumn(name = "job_id"),
			inverseJoinColumns = @JoinColumn(name = "doctor_id")
	)
	private Set<Doctor> doctorsAccepted = new HashSet<>();

	private Integer openPositions;
	
}
