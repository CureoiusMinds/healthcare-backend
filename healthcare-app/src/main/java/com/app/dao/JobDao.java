package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Job;

public interface JobDao extends JpaRepository<Job, Long> {

}
