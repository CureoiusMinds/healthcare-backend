package com.app.service;

import com.app.dao.DoctorDao;
import com.app.dao.HospitalDao;
import com.app.dao.JobDao;
import com.app.dto.DoctorGetDTO;
import com.app.dto.HospitalDTO;
import com.app.dto.JobDTO;
import com.app.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    HospitalDao hospitalDao;

    @Autowired
    JobDao jobDao;

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    ModelMapper mapper;
    @Override
    public HospitalDTO getHospital(Long hospId) {
        return mapper.map(hospitalDao.findById(hospId).orElseThrow(), HospitalDTO.class);
    }

    @Override
    public void updateHospital(Long hospId, HospitalDTO hospitalDTO) {
        Hospital hospital = hospitalDao.findById(hospId).orElseThrow();
        hospital.setLocation(hospitalDTO.getLocation());
        hospital.setDescription(hospitalDTO.getDescription());
        hospital.setName(hospitalDTO.getName());
    }

    @Override
    public List<JobDTO> getJobsPosted(Long hospId) {
        return jobDao.findJobByHospital(hospitalDao.getReferenceById(hospId)).stream()
                .map((job)->mapper.map(job, JobDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JobDTO getJob(Long hospId, Long jobId) {
        return mapper.map(jobDao.findById(jobId).orElseThrow(), JobDTO.class);
    }

    @Override
    public void addJob(Long hospId, JobDTO jobDTO) {
        Job job = mapper.map(jobDTO, Job.class);
        jobDao.save(job);
    }

    @Override
    public void updateJob(Long hospId, Long jobId, JobDTO jobDTO) {
        Job job = jobDao.findById(jobId).orElseThrow();
        mapper.map(jobDTO, job);
    }

    @Override
    public void deleteJob(Long hospId, Long jobId) {
        jobDao.deleteById(jobId);
    }

    @Override
    public List<DoctorGetDTO> getApplicants(Long hospId, Long jobId) {
        return jobDao.findById(jobId).orElseThrow().getDoctorsApplied().stream()
                .map((doctor)->mapper.map(doctor, DoctorGetDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<DoctorGetDTO> getAccepted(Long hospId, Long jobId) {
        return jobDao.findById(jobId).orElseThrow().getDoctorsAccepted().stream()
                .map((doctor)->mapper.map(doctor, DoctorGetDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void acceptRequest(Long hospId, Long jobId, Long doctorId) {
        Job job = jobDao.findById(jobId).orElseThrow();
        job.setOpenPositions(job.getOpenPositions()-1);
        job.getDoctorsAccepted().add(doctorDao.getReferenceById(doctorId));
    }

    @Override
    public void rejectRequest(Long hospId, Long jobId, Long doctorId) {
        Job job = jobDao.findById(jobId).orElseThrow();
        job.getDoctorsApplied().remove(doctorDao.getReferenceById(doctorId));
    }
}
