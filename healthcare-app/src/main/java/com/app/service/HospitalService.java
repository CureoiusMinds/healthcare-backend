package com.app.service;

import com.app.dto.DoctorGetDTO;
import com.app.dto.HospitalDTO;
import com.app.dto.JobDTO;

import java.util.List;

public interface HospitalService {
    HospitalDTO getHospital(Long hospId);
    void updateHospital(Long hospId, HospitalDTO hospitalDTO);
    List<JobDTO> getJobsPosted(Long hospId);
    JobDTO getJob(Long hospId, Long jobId);
    void updateJob(Long hospId, Long jobId, JobDTO jobDTO);
    void deleteJob(Long hospId, Long jobId);
    List<DoctorGetDTO> getApplicants(Long hospId, Long jobId);
    List<DoctorGetDTO> getAccepted(Long hospId, Long jobId);
    void acceptRequest(Long hospId, Long jobId, Long doctorId);
    void rejectRequest(Long hospId, Long jobId, Long doctorId);

}
