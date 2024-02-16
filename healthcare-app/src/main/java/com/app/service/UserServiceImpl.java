package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserEntityDao;
import com.app.dto.Signup;
import com.app.entities.Doctor;
import com.app.entities.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public Signup userRegistration(Signup reqDTO) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Signup userRegistration(Signup reqDTO) {
//		//dto --> entity
////		Doctor user=mapper.map(reqDTO, Doctor.class);
////		UserEntity user = user.getUserEntity().setPassword(encoder.encode(user.getUserEntity().getPassword()));//pwd : encrypted using SHA
////		return mapper.map(userDao.save(user), Signup.class);
//	}

}
