package com.app.service;


import com.app.entities.UserEntity;

import javax.validation.Valid;

import org.apache.catalina.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DoctorDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.DoctorSignup;
import com.app.dto.Signup;
import com.app.entities.Doctor;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private DoctorDao doctorDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep
	@Autowired
	private PasswordEncoder encoder;

//	@Override
//	public Signup userRegistration(Signup reqDTO) {
//		//dto --> entity
//	}

	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), Signup.class);

	public ApiResponse doctorRegistration(@Valid DoctorSignup dto) {
		UserEntity user = new UserEntity();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setRole(UserRole.ROLE_DOCTOR);
		
		UserEntity persistUser =  userDao.save(user);
		
		
		Doctor doctor = mapper.map(dto, Doctor.class);
		doctor.setUserEntity(persistUser);
		
		doctorDao.save(doctor);
				
		//doctor.getUserEntity().setPassword(encoder.encode(user.getUserEntity().getPassword()));//pwd : encrypted using SHA
		return new ApiResponse(HttpStatus.OK.value(),"Doctor Registration successful.");
	}


}
