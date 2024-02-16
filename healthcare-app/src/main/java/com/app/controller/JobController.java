package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.JobDTO;
import com.app.service.JobService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
//
//@RestController
//@RequestMapping("/jobs")
//public class JobController {
//
//	@Autowired
//	JobService jobService;
//
//
//	@GetMapping("/all")
//	public ResponseEntity<List<JobDTO>> getJobs()
//	{
//		return ResponseEntity.ok(jobService.getAllJobs());
//	}
//
//	@PostMapping
//	public ResponseEntity<?> addJob(@RequestBody @Valid JobDTO jobDTO)
//	{
//		ApiResponse apiResponse = jobService.addJob(jobDTO);
//		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//	}
//
//	@DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
//        ApiResponse apiResponse = jobService.deleteJob(id);
//        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//    }
//
//	@PutMapping("/edit/{id}")
//    public ResponseEntity<?> updateJob(@PathVariable Long id, @Valid @RequestBody JobDTO jobDTO) {
//        ApiResponse apiResponse = jobService.updateJob(id, jobDTO);
//        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
//    }
//
//}
