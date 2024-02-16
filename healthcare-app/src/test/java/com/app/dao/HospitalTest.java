package com.app.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Hospital;
import com.app.entities.Specialization;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@Rollback(value = false) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HospitalTest {

    @Autowired
    private HospitalDao hospitalRepository;

    @Autowired
    private UserEntityDao userEntityDao;

    @Test
    @Transactional
    public void testSaveMultipleHospitals() {
        // Create and save UserEntities for hospital administrators
        UserEntity admin1 = userEntityDao.save(new UserEntity("HospitalAdmin1", "Admin", "admin1@hospital.com", "password", UserRole.ROLE_HOSPITAL));
        UserEntity admin2 = userEntityDao.save(new UserEntity("HospitalAdmin2", "Admin", "admin2@hospital.com", "password", UserRole.ROLE_HOSPITAL));
        UserEntity admin3 = userEntityDao.save(new UserEntity("HospitalAdmin3", "Admin", "admin3@hospital.com", "password", UserRole.ROLE_HOSPITAL));
        UserEntity admin4 = userEntityDao.save(new UserEntity("HospitalAdmin4", "Admin", "admin4@hospital.com", "password", UserRole.ROLE_HOSPITAL));
        UserEntity admin5 = userEntityDao.save(new UserEntity("HospitalAdmin5", "Admin", "admin5@hospital.com", "password", UserRole.ROLE_HOSPITAL));

        // Create Hospital entities and link with UserEntities
        Hospital hospital1 = createHospital(admin1, "Hospital 1", "Location 1", Specialization.GYNECOLOGY);
        Hospital hospital2 = createHospital(admin2, "Hospital 2", "Location 2", Specialization.CARDIOLOGY);
        Hospital hospital3 = createHospital(admin3, "Hospital 3", "Location 3", Specialization.NEUROLOGY);
        Hospital hospital4 = createHospital(admin4, "Hospital 4", "Location 4", Specialization.ORTHOPEDICS);
        Hospital hospital5 = createHospital(admin5, "Hospital 5", "Location 5", Specialization.ORTHOPEDICS);

        // Save Hospitals
        hospitalRepository.saveAll(List.of(hospital1, hospital2, hospital3, hospital4, hospital5));

        // Verify saved hospitals
        assertThat(hospital1.getId()).isNotNull();
        assertThat(hospital2.getId()).isNotNull();
        assertThat(hospital3.getId()).isNotNull();
        assertThat(hospital4.getId()).isNotNull();
        assertThat(hospital5.getId()).isNotNull();
    }

    private Hospital createHospital(UserEntity userEntity, String name, String location, Specialization specialization) {
        Hospital hospital = new Hospital();
        hospital.setUserEntity(userEntity);
        hospital.setName(name);
        hospital.setLocation(location);
        hospital.setSpecialization(specialization);
        return hospital;
    }

}
