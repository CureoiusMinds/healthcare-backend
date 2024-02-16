package com.app.service;

import com.app.dao.DoctorDao;
import com.app.dao.GroupDao;
import com.app.dao.JobDao;
import com.app.dto.DoctorGetDTO;
import com.app.dto.DoctorPutDTO;
import com.app.dto.GroupDTO;
import com.app.dto.JobDTO;
import com.app.entities.Doctor;
import com.app.entities.Group;

import com.app.exception.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<JobDTO> viewJobs(Long docId) {
        return jobDao.findAll().stream().map((job)->mapper.map(job, JobDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> viewAppliedJobs(Long docId) {

        return doctorDao.findById(docId).orElseThrow(()->new ResourceNotFound("Doctor does not exist yet !")).getJobsApplied().stream()
                .map((job)->mapper.map(job, JobDTO.class)).collect(Collectors.toList())    ;
    }

    @Override
    public List<JobDTO> viewAcceptedJobs(Long docId) {
        return doctorDao.findById(docId).orElseThrow(()->new ResourceNotFound("Doctor does not exist yet !")).getJobsAccepted().stream()
                .map((job)->mapper.map(job, JobDTO.class)).collect(Collectors.toList());
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
    public DoctorGetDTO viewProfile(Long docId) {
        return mapper.map(doctorDao.findById(docId).orElseThrow(()->new ResourceNotFound("Doctor does not exist yet !")), DoctorGetDTO.class);
    }

    @Override
    public DoctorGetDTO updateProfile(Long docId, DoctorPutDTO newDoctorDetails) {
        Doctor doctorNew = mapper.map(newDoctorDetails, Doctor.class);
        doctorNew.setId(docId);
        return mapper.map(doctorNew, DoctorGetDTO.class);
    }

    @Override
    public void createGroup(Long docId, GroupDTO groupDTO) {
        Group group = mapper.map(groupDTO, Group.class);
        group.setGroupLeader(doctorDao.getReferenceById(docId));
        doctorDao.getReferenceById(docId).setGroup(group);
        groupDao.save(group);
    }

    @Override
    public List<DoctorGetDTO> getDocs() {
        return doctorDao.findAll().stream().map((doctor)->mapper.map(doctor, DoctorGetDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteGroup(Long docId) {
        groupDao.delete(doctorDao.getReferenceById(docId).getGroup());
        doctorDao.getReferenceById(docId).setGroup(null);
    }

    @Override
    public GroupDTO viewGroup(Long docId) {
        Group group = doctorDao.findById(docId).orElseThrow(()->new ResourceNotFound("Group does not exist yet !")).getGroup();
        return mapper.map(group, GroupDTO.class);
    }
}
