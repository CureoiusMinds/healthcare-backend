package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.JobDao;
import com.app.dto.ApiResponse;
import com.app.dto.HospitalDTO;
import com.app.dto.JobDTO;
import com.app.entities.Hospital;
import com.app.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
@CrossOrigin("*")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/all")
	public ResponseEntity<List<HospitalDTO>> getHospitals()
	{
		return ResponseEntity.ok(hospitalService.getAllHospitals());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewHospital(@RequestBody @Valid HospitalDTO hospitalDTO){
		
		ApiResponse apiResponse = hospitalService.addHospital(hospitalDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PutMapping("edit/{Id}")
	public ResponseEntity<?> UpdateHospitalDetails(@PathVariable Long id, @Valid @RequestBody HospitalDTO hospitalDTO){
		
		ApiResponse apiResponse = hospitalService.addHospital(hospitalDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
