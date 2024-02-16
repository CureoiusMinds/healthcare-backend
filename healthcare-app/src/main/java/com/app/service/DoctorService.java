package com.app.service;

import com.app.dto.DoctorGetDTO;
import com.app.dto.DoctorPutDTO;
import com.app.dto.GroupDTO;
import com.app.dto.JobDTO;

import java.util.List;

public interface DoctorService {

    List<JobDTO> viewJobs(Long docId);
    List<JobDTO> viewAppliedJobs(Long docId);
    List<JobDTO> viewAcceptedJobs(Long docId);
    void applyForAJob(Long docId, Long jobId);
    void withdrawApplication(Long docId, Long jobId);

    DoctorGetDTO viewProfile(Long docId);
    DoctorGetDTO updateProfile(Long docId, DoctorPutDTO newDoctorDetails);

    void createGroup(Long docId, GroupDTO groupDTO);
    List<DoctorGetDTO> getDocs();
    void deleteGroup(Long docId);
    GroupDTO viewGroup(Long docId);


}
