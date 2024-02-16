package com.app.dao;

import com.app.entities.Hospital;
import com.app.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobDao extends JpaRepository<Job,Long> {

    List<Job> findJobByHospital(Hospital hospital);
}
