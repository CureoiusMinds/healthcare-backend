package com.app.dao;

import com.app.entities.Doctor;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorTest {

    @Autowired
    DoctorDao doctorDao;

    @Test
    void insertDoctor()
    {
        UserEntity userEntity = new UserEntity("doctor1", "doctor2", "doc1@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
        Doctor doctor = new Doctor(userEntity, "A122we");
        doctorDao.save(doctor);

         userEntity = new UserEntity("doctor3", "doctor4", "doc2@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
         doctor = new Doctor(userEntity, "B74982");
        doctorDao.save(doctor);


        userEntity = new UserEntity("doctor5", "doctor6", "doc3@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
        doctor = new Doctor(userEntity, "C0832");
        doctorDao.save(doctor);


        userEntity = new UserEntity("doctor7", "doctor8", "doc4@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
        doctor = new Doctor(userEntity, "D089324");
        doctorDao.save(doctor);


        userEntity = new UserEntity("doctor9", "doctor10", "doc5@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
        doctor = new Doctor(userEntity, "E092834");
        doctorDao.save(doctor);

    }
}
