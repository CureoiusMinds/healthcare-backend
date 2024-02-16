package com.app.dao;

import java.util.Optional;

import com.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;

public interface UserEntityDao extends JpaRepository<UserEntity,Long>{
//derived finder
//	Optional<Doctor> findByE(String email);
}
