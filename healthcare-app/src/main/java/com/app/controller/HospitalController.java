package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.JobDao;
import com.app.dto.HospitalDTO;
import com.app.entities.Hospital;
import com.app.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/all")
	public ResponseEntity<List<HospitalDTO>> getHospitals()
	{
		return ResponseEntity.ok(hospitalService.getAllHospitals());
	}
}
