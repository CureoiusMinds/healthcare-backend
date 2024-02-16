package com.app.service;

import com.app.dto.DoctorPutDTO;
import com.app.dto.GroupDTO;
import com.app.entities.Doctor;
import com.app.entities.Job;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    List<Job> viewJobs(Long docId);
    Set<Job> viewAppliedJobs(Long docId);
    Set<Job> viewAcceptedJobs(Long docId);
    void applyForAJob(Long docId, Long jobId);
    void withdrawApplication(Long docId, Long jobId);

    Doctor viewProfile(Long docId);
    Doctor updateProfile(Long docId, DoctorPutDTO newDoctorDetails);

    void createGroup(Long docId, GroupDTO groupDTO);
    List<Doctor> getDocs();
    void deleteGroup(Long docId);
    GroupDTO viewGroup(Long docId);


}
