package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Doctor;
import com.app.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class DoctorDaoTest {
	// dep
	@Autowired
	private UserEntityDao userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Test
	void testAddUsers() {
		/*
		 * List<Doctor> list = List.of( new Doctor("a1", "b1", "a1@gmail.com",
		 * enc.encode("12345"), UserRole.ROLE_ADMIN), new Doctor("a2", "b2",
		 * "a2@gmail.com", enc.encode("2345"), UserRole.ROLE_CUSTOMER), new Doctor("a3",
		 * "b3", "a3@gmail.com", enc.encode("1345"), UserRole.ROLE_USER)); List<Doctor>
		 * list2 = userRepo.saveAll(list); assertEquals(3, list2.size());
		 */

	}

}
