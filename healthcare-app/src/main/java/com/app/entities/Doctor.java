package com.app.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctors")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
public class Doctor extends BaseEntity {
	@OneToOne
			@MapsId
			@JoinColumn(name = "doctor_id")
	UserEntity userEntity;
	@Column(length = 14)
	private String mobileNo;
	@Column
	private LocalDate DoB;
	@Column
	private Integer noOfCases;
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
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToMany(mappedBy = "doctorsApplied")
	Set<Job> jobsApplied = new HashSet<>();

	@ManyToMany(mappedBy = "doctorsAccepted")
	Set<Job> jobsAccepted = new HashSet<>();

}
