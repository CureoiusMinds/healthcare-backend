package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "hospital_id")
	UserEntity userEntity;

	@Column(length = 100, nullable = false)
	String name;

	@Column(length = 100, nullable = false)
	String location;

	@Enumerated(EnumType.STRING)
	Specialization specialization;
}
