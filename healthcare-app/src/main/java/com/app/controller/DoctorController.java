package com.app.controller;


import com.app.dto.GroupDTO;
import com.app.entities.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctor/{doc_id}")
public class DoctorController {

    //doctor profile endpoints
    @GetMapping("/profile")
    public ResponseEntity<?> getDocProfile(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }
    @PutMapping("/profile/update")
    public ResponseEntity<?> updateDocProfile(@PathVariable Long doc_id, @RequestBody Doctor doctorUpdated)
    {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //jobs endpoints
    @GetMapping("/jobs")
    public ResponseEntity<?> getAllJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }
    @PutMapping("/apply/{job_id}")
    public ResponseEntity<?> applyForAJob(@PathVariable Long doc_id, @PathVariable Long job_id)
    {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/view-applied")
    public ResponseEntity<?> getAppliedJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/view-accepted")
    public ResponseEntity<?> getAcceptedJobs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{job_id}")
    public ResponseEntity<?> withdrawApplication(@PathVariable Long doc_id, @PathVariable Long job_id)
    {
        return ResponseEntity.ok().build();
    }

    //Group endpoints
    @PostMapping("/create-group")
    public ResponseEntity<?> createGroup(@PathVariable Long doc_id, @RequestBody GroupDTO newGroup)
    {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/create-group/get-doctors")
    public ResponseEntity<?> getAllDocs(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/view-group")
    public ResponseEntity<?> getGroup(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }
    @DeleteMapping ("/delete-group")
    public ResponseEntity<?> deleteGroup(@PathVariable Long doc_id)
    {
        return ResponseEntity.ok().build();
    }


}
