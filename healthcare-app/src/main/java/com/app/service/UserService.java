package com.app.service;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.DoctorSignup;
import com.app.dto.HospitalSignup;
import com.app.dto.Signup;

public interface UserService {
//sign up
	//Signup userRegistration(Signup reqDTO);
	ApiResponse doctorRegistration(@Valid DoctorSignup dto);

	ApiResponse hospitalRegistration(@Valid HospitalSignup dto);
}
