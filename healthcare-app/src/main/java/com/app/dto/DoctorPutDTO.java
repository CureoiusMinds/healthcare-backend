package com.app.dto;

import com.app.entities.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPutDTO {
    private Integer noOfCases;
    private Integer yearsOfEx;
    private String underGrad;
    private String postGrad;
    private String otherQualifications;
    private String prevEmployment;
    private String bioNote;
    private String city;
    private String state;
    private String country;
    Specialization specialization;

}
