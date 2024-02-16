package com.app.dao;

import com.app.entities.Doctor;
import com.app.service.DoctorService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorDao extends JpaRepository<Doctor, Long> {
}
