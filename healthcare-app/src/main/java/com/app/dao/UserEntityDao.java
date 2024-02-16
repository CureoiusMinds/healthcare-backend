package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;

public interface UserEntityDao extends JpaRepository<Doctor,Long>{
//derived finder
//	Optional<Doctor> findByE(String email);
}
