package com.app.service;

import com.app.dao.DoctorDao;
import com.app.dao.JobDao;
import com.app.dto.DoctorPutDTO;
import com.app.dto.GroupDTO;
import com.app.entities.Doctor;
import com.app.entities.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    JobDao jobDao;

    @Autowired
    DoctorDao doctorDao;
    @Override
    public List<Job> viewJobs(Long docId) {
        return jobDao.findAll();
    }

    @Override
    public Set<Job> viewAppliedJobs(Long docId) {

        return doctorDao.findById(docId).orElseThrow().getJobsApplied();
    }

    @Override
    public Set<Job> viewAcceptedJobs(Long docId) {
        return doctorDao.findById(docId).orElseThrow().getJobsAccepted();
    }

    @Override
    public void applyForAJob(Long docId, Long jobId) {
        doctorDao.getReferenceById(docId).getJobsApplied().add(jobDao.getReferenceById(jobId));
        jobDao.getReferenceById(jobId).getDoctorsApplied().add(doctorDao.getReferenceById(docId));
    }

    @Override
    public void withdrawApplication(Long docId, Long jobId) {

    }

    @Override
    public Doctor viewProfile(Long docId) {
        return null;
    }

    @Override
    public Doctor updateProfile(Long docId, DoctorPutDTO newDoctorDetails) {
        return null;
    }

    @Override
    public void createGroup(Long docId, GroupDTO groupDTO) {

    }

    @Override
    public List<Doctor> getDocs() {
        return null;
    }

    @Override
    public void deleteGroup(Long docId) {

    }

    @Override
    public GroupDTO viewGroup(Long docId) {
        return null;
    }
}
