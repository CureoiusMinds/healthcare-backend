package com.app.dao;

import com.app.entities.Doctor;
import com.app.entities.Specialization;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorTest {

/*
    @Test
    void insertDoctor()
    {
        UserEntity userEntity = new UserEntity("doctor1", "doctor2", "doc1@gmail.com", "Password@22", UserRole.ROLE_DOCTOR);
        Doctor doctor = new Doctor();
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
    */
    @Autowired
    private DoctorDao doctorRepository;
    
    @Autowired
    private UserEntityDao userEntityDao;

    @Test
    @Transactional
    public void testSaveMultipleDoctors() {
        // Create and save UserEntities for doctors
        UserEntity userEntity1 = userEntityDao.save(new UserEntity("John", "Doe", "john@gmail.com", "password", UserRole.ROLE_DOCTOR));
        UserEntity userEntity2 = userEntityDao.save(new UserEntity("Jane", "Smith", "jane@gmail.com", "password", UserRole.ROLE_DOCTOR));
        UserEntity userEntity3 = userEntityDao.save(new UserEntity("Michael", "Johnson", "michael@gmail.com", "password", UserRole.ROLE_DOCTOR));
        UserEntity userEntity4 = userEntityDao.save(new UserEntity("Emily", "Brown", "emily@gmail.com", "password", UserRole.ROLE_DOCTOR));
        UserEntity userEntity5 = userEntityDao.save(new UserEntity("David", "Wilson", "david@gmail.com", "password", UserRole.ROLE_DOCTOR));

        // Create Doctor entities and link with UserEntities
        Doctor doctor1 = createDoctor(userEntity1, "123456", Specialization.CARDIOLOGY);
        Doctor doctor2 = createDoctor(userEntity2, "234567", Specialization.NEUROLOGY);
        Doctor doctor3 = createDoctor(userEntity3, "345678", Specialization.ORTHOPEDICS);
        Doctor doctor4 = createDoctor(userEntity4, "456789", Specialization.GYNECOLOGY);
        Doctor doctor5 = createDoctor(userEntity5, "567890", Specialization.ONCOLOGY);

        // Save Doctors
        doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3, doctor4, doctor5));

        // Verify saved doctors
        assertThat(doctor1.getId()).isNotNull();
        assertThat(doctor2.getId()).isNotNull();
        assertThat(doctor3.getId()).isNotNull();
        assertThat(doctor4.getId()).isNotNull();
        assertThat(doctor5.getId()).isNotNull();
    }

    private Doctor createDoctor(UserEntity userEntity, String medicalLicenseId, Specialization specialization) {
        Doctor doctor = new Doctor();
        doctor.setUserEntity(userEntity);
        doctor.setMobileNo("1234567890");
        doctor.setDoB(LocalDate.of(1980, 1, 1));
        doctor.setNoOfCases(100);
        doctor.setYearsOfEx(10);
        doctor.setUnderGrad("Medical College");
        doctor.setPostGrad("Specialty College");
        doctor.setOtherQualifications("Additional certifications");
        doctor.setPrevEmployment("Previous Hospital");
        doctor.setBioNote("About the doctor");
        doctor.setCity("City");
        doctor.setState("State");
        doctor.setCountry("Country");
        doctor.setMedicalLicenseId(medicalLicenseId);
        doctor.setSpecialization(specialization);
        return doctor;
    }
    
    
    
    
    

}
