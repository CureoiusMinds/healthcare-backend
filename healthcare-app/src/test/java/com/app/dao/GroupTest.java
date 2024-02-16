package com.app.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Group;
import com.app.entities.Doctor;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@Rollback(value = false) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class GroupTest {

    @Autowired
    private GroupDao groupRepository;

    @Autowired
    private DoctorDao doctorRepository;

    @Test
    @Transactional
    public void testSaveMultipleGroups() {
        // Create and save Doctors to serve as group leaders
        Doctor leader1 = createDoctor("GroupLeader1", "Leader", "leader1@example.com", "password");
        Doctor leader2 = createDoctor("GroupLeader2", "Leader", "leader2@example.com", "password");
        Doctor leader3 = createDoctor("GroupLeader3", "Leader", "leader3@example.com", "password");
        Doctor leader4 = createDoctor("GroupLeader4", "Leader", "leader4@example.com", "password");
        Doctor leader5 = createDoctor("GroupLeader5", "Leader", "leader5@example.com", "password");

        // Create Group entities and link with group leaders
        Group group1 = createGroup(leader1, 10, "Group 1 description");
        Group group2 = createGroup(leader2, 8, "Group 2 description");
        Group group3 = createGroup(leader3, 12, "Group 3 description");
        Group group4 = createGroup(leader4, 6, "Group 4 description");
        Group group5 = createGroup(leader5, 15, "Group 5 description");

        // Save Groups
        groupRepository.saveAll(List.of(group1, group2, group3, group4, group5));

        // Verify saved groups
        assertThat(group1.getId()).isNotNull();
        assertThat(group2.getId()).isNotNull();
        assertThat(group3.getId()).isNotNull();
        assertThat(group4.getId()).isNotNull();
        assertThat(group5.getId()).isNotNull();
    }

    private Doctor createDoctor(String firstName, String lastName, String email, String password) {
        UserEntity userEntity = new UserEntity(firstName, lastName, email, password, UserRole.ROLE_DOCTOR);
        Doctor doctor = new Doctor(userEntity, "123456"); // Assuming medicalLicenseId is a required field
        return doctorRepository.save(doctor);
    }

    private Group createGroup(Doctor groupLeader, Integer groupStrength, String description) {
        Group group = new Group();
        group.setGroupLeader(groupLeader);
        group.setGroupStrength(groupStrength);
        group.setDescription(description);
        return group;
    }

}
