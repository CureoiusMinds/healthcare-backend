package com.app.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "jobs")
@AttributeOverride(name = "id", column = @Column(name = "job_id"))
public class JobEntity extends BaseEntity{
	String title;
	String description;
	Double offerPrice;
	Specialization specialization;
	
	
}
