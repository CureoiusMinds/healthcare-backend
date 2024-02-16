package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Hospital;

public interface HospitalDao extends JpaRepository<Hospital, Long>{

}
