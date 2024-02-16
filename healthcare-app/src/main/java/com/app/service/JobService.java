package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import com.app.dto.ApiResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dao.JobDao;
import com.app.dto.ApiResponse;
import com.app.dto.JobDTO;
import com.app.entities.Job;
import com.app.exception.ResourceNotFound;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Service
@Getter
@Setter
public class JobService {
	
	@Autowired
	JobDao jobDao;
	
	@Autowired
	ModelMapper mapper;
	
	public List<JobDTO> getAllJobs()
	{
		List<Job> jobs = jobDao.findAll();
		
		List<JobDTO> jobDTOs = 
				jobs.stream().map(e->mapper.map(e, JobDTO.class))
				.collect(Collectors.toList());
		
		return jobDTOs;
	}

	public ApiResponse addJob( JobDTO jobDTO) {
		
		Job job = mapper.map(jobDTO, Job.class);
		jobDao.save(job);
		return new ApiResponse(HttpStatus.OK.value(),"job added successfully!!");
	}

	public ApiResponse deleteJob(Long id) {
		Job job = jobDao.findById(id).orElseThrow(()->new ResourceNotFound("Course not found!!"));
		jobDao.delete(job);
		return new ApiResponse(HttpStatus.OK.value(),"job deleted successfully!!");
	}

	public ApiResponse updateJob(Long id, @Valid JobDTO jobDTO) {
		Job job = jobDao.findById(id).orElseThrow(()->new ResourceNotFound("Course not found!!"));
		Job updatedJob = mapper.map(jobDTO, Job.class);
		jobDao.save(updatedJob);
		return new ApiResponse(HttpStatus.OK.value(), "Job updated successfully");
	}
	
	
}
