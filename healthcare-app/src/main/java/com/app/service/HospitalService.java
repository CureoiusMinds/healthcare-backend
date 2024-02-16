package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dao.HospitalDao;
import com.app.dto.ApiResponse;
import com.app.dto.HospitalDTO;
import com.app.dto.JobDTO;
import com.app.entities.Hospital;
import com.app.entities.Job;
import com.app.exception.ResourceNotFound;

@Service
public class HospitalService {
	@Autowired
	HospitalDao hospitalDao;
	
	@Autowired
	ModelMapper mapper;
	
	public List<HospitalDTO> getAllHospitals()
	{
		List<Hospital> hospitals = hospitalDao.findAll();
		List<HospitalDTO> hospitalDTOs = 
				hospitals.stream().map(e->(mapper.map(e, HospitalDTO.class))).collect(Collectors.toList());
		return hospitalDTOs;
	}
	
	public ApiResponse addHospital( HospitalDTO hospitalDTO) {
		
		Hospital hospitaldto = mapper.map(hospitalDTO, Hospital.class);
		hospitalDao.save(hospitaldto);
		return new ApiResponse(201,"course added successfully!!");
	}
	
	public ApiResponse updateHospitalDetails(Long id, @Valid HospitalDTO hospitalDTO) {
		Hospital hospital = hospitalDao.findById(id).orElseThrow(()->new ResourceNotFound("Course not found!!"));
		Hospital updatedHospital = mapper.map(hospitalDTO, Hospital.class);
		hospitalDao.save(updatedHospital);
		return new ApiResponse(HttpStatus.OK.value(), "Job updated successfully");
	}
	
	
}
