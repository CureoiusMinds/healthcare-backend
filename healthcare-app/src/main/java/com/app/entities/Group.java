package com.app.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor_groups")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "group_id"))
public class Group extends BaseEntity{

    @OneToOne
    private Doctor groupLeader;
    @Column
    private Integer groupStrength;
    @Column(length = 100)
    private String description;
    @OneToMany(mappedBy = "group")
    private List<Doctor> doctorList;

    @ManyToMany(mappedBy = "groupsApplied")
    Set<Job> jobsApplied = new HashSet<>();

    @ManyToMany(mappedBy = "groupsAccepted")
    Set<Job> jobsAccepted = new HashSet<>();
}
