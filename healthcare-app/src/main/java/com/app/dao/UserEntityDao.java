package com.app.dao;

import java.util.Optional;

import com.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;
import com.app.entities.UserEntity;

public interface UserEntityDao extends JpaRepository<UserEntity,Long>{
//derived finder
//	Optional<Doctor> findByE(String email);
}
