package com.app.service;

import com.app.dao.DoctorDao;
import com.app.dao.GroupDao;
import com.app.dao.JobDao;
import com.app.dto.DoctorPutDTO;
import com.app.dto.GroupDTO;
import com.app.entities.Doctor;
import com.app.entities.Group;
import com.app.entities.Job;

import org.modelmapper.ModelMapper;
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

    @Autowired
    GroupDao groupDao;

    @Autowired
    ModelMapper mapper;
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
        doctorDao.getReferenceById(docId).getJobsApplied().remove(jobDao.getReferenceById(jobId));
        jobDao.getReferenceById(jobId).getDoctorsApplied().remove(doctorDao.getReferenceById(docId));
    }

    @Override
    public Doctor viewProfile(Long docId) {
        return doctorDao.findById(docId).orElseThrow();
    }

    @Override
    public Doctor updateProfile(Long docId, DoctorPutDTO newDoctorDetails) {
        Doctor doctorNew = mapper.map(newDoctorDetails, Doctor.class);
        doctorNew.setId(docId);
        return doctorNew;
    }

    @Override
    public void createGroup(Long docId, GroupDTO groupDTO) {
        Group group = mapper.map(groupDTO, Group.class);
        group.setGroupLeader(doctorDao.getReferenceById(docId));
        doctorDao.getReferenceById(docId).setGroup(group);
        groupDao.save(group);
    }

    @Override
    public List<Doctor> getDocs() {
        return doctorDao.findAll();
    }

    @Override
    public void deleteGroup(Long docId) {
        groupDao.delete(doctorDao.getReferenceById(docId).getGroup());
        doctorDao.getReferenceById(docId).setGroup(null);
    }

    @Override
    public GroupDTO viewGroup(Long docId) {
        Group group = doctorDao.findById(docId).orElseThrow().getGroup();
        return mapper.map(group, GroupDTO.class);
    }
}
