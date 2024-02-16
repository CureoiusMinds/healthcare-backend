package com.app.dto;

import com.app.entities.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorGetDTO {

    private String userEntityFirstName;

    private String userEntityLastName;
    private String userEntityEmail;
    private String mobileNo;
    private LocalDate DoB;
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
    private String medicalLicenseId;

    Specialization specialization;

}
