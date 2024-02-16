package com.app.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
public class Doctor extends BaseEntity {
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 30, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
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

}
