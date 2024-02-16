package com.app.dao;

import com.app.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job,Long> {

}
