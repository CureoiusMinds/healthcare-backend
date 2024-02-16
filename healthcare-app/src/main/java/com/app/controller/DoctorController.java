package com.app.controller;


import com.app.dto.DoctorPutDTO;

import com.app.dto.GroupDTO;
import com.app.entities.Doctor;
import com.app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctor/{doc_id}")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //doctor profile endpoints
    @GetMapping("/profile")
    public ResponseEntity<?> getDocProfile(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.viewProfile(doc_id));
    }
    @PutMapping("/profile/update")
    public ResponseEntity<?> updateDocProfile(@PathVariable Long doc_id, @RequestBody DoctorPutDTO doctorUpdated)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.updateProfile(doc_id, doctorUpdated));
    }

    //jobs endpoints
    @GetMapping("/jobs")
    public ResponseEntity<?> getAllJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.viewJobs(doc_id));
    }
    @PutMapping("/apply/{job_id}")
    public ResponseEntity<?> applyForAJob(@PathVariable Long doc_id, @PathVariable Long job_id)
    {
        doctorService.applyForAJob(doc_id, job_id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/view-applied")
    public ResponseEntity<?> getAppliedJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.viewAppliedJobs(doc_id));
    }

    @GetMapping("/view-accepted")
    public ResponseEntity<?> getAcceptedJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.viewAcceptedJobs(doc_id));
    }

    @DeleteMapping("/delete/{job_id}")
    public ResponseEntity<?> withdrawApplication(@PathVariable Long doc_id, @PathVariable Long job_id)
    {
        doctorService.withdrawApplication(doc_id, job_id);
        return ResponseEntity.ok().build();
    }

    //Group endpoints
    @PostMapping("/create-group")
    public ResponseEntity<?> createGroup(@PathVariable Long doc_id, @RequestBody GroupDTO newGroup)
    {
        doctorService.createGroup(doc_id,newGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/create-group/get-doctors")
    public ResponseEntity<?> getAllDocs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.getDocs());
    }
    @GetMapping("/view-group")
    public ResponseEntity<?> getGroup(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().body(doctorService.viewGroup(doc_id));
    }
    @DeleteMapping ("/delete-group")
    public ResponseEntity<?> deleteGroup(@PathVariable Long doc_id)
    {
        doctorService.deleteGroup(doc_id);
        return ResponseEntity.ok().build();
    }


}
