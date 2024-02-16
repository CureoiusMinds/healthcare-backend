package com.app.controller;

import javax.validation.Valid;

import com.app.dto.JobDTO;
import com.app.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ApiResponse;
import com.app.dto.HospitalDTO;

@RestController
@RequestMapping("/hospital/{hosp_id}")
@CrossOrigin("*")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;

	@GetMapping
	public ResponseEntity<?> getHospital(@PathVariable Long hosp_id)
	{
		return ResponseEntity.ok().body(hospitalService.getHospital(hosp_id));
	}

	@PutMapping("/edit-profile")
	public ResponseEntity<?> updateHospitalDetails(@PathVariable Long hosp_id, @Valid @RequestBody HospitalDTO hospitalDTO){

		hospitalService.updateHospital(hosp_id, hospitalDTO);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/jobs")
	public ResponseEntity<?> getAllJobs(@PathVariable Long hosp_id)
	{
		return ResponseEntity.ok().body(hospitalService.getJobsPosted(hosp_id));
	}

	@GetMapping("/jobs/{job_id}")
	public ResponseEntity<?> getJob(@PathVariable Long hosp_id, @PathVariable Long job_id)
	{
		return ResponseEntity.ok().body(hospitalService.getJob(hosp_id, job_id));
	}
	@GetMapping("/jobs/{job_id}/appilcants")
	public ResponseEntity<?> getJobApplicants(@PathVariable Long hosp_id, @PathVariable Long job_id)
	{
		return ResponseEntity.ok().body(hospitalService.getApplicants(hosp_id,job_id));
	}
	@GetMapping("/jobs/{job_id}/accepted-applicants")
	public ResponseEntity<?> getJobAccepted(@PathVariable Long hosp_id, @PathVariable Long job_id)
	{
		return ResponseEntity.ok().body(hospitalService.getAccepted(hosp_id,job_id));
	}

	@PutMapping("/jobs/{job_id}/update")
	public ResponseEntity<?> updateJob(@PathVariable Long hosp_id, @PathVariable Long job_id, @RequestBody JobDTO jobDTO)
	{
		hospitalService.updateJob(hosp_id, job_id, jobDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/jobs/{job_id}/accept/{doctor_id}")
	public ResponseEntity<?> acceptDoctor(@PathVariable Long hosp_id, @PathVariable Long job_id, @PathVariable Long doctor_id)
	{
		hospitalService.acceptRequest(hosp_id, job_id, doctor_id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/jobs/{job_id}/reject/{doctor_id}")
	public ResponseEntity<?> rejectDoctor(@PathVariable Long hosp_id, @PathVariable Long job_id, @PathVariable Long doctor_id)
	{
		hospitalService.rejectRequest(hosp_id, job_id, doctor_id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/jobs/{job_id}/delete")
	public ResponseEntity<?> deleteJob(@PathVariable Long hosp_id, @PathVariable Long job_id)
	{
		hospitalService.deleteJob(hosp_id,job_id);
		return ResponseEntity.ok().build();
	}

}
