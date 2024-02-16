package com.app.dao;

import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class SecureUserTest {

    @Autowired
    private  UserEntityDao userEntityDao;
    @Test
    void addSecureUser(){
        List<UserEntity> users = List.of(
          new UserEntity("Praneet","Walvekar","praneet@gmail.com","praneet#123", UserRole.ROLE_DOCTOR),
                new UserEntity("Kushagra","Khattri","kushagra@gmail.com","kushagra#123", UserRole.ROLE_DOCTOR),
                new UserEntity("Meet","Vasani","meet@gmail.com","meet#123", UserRole.ROLE_DOCTOR),
                new UserEntity("Sanjavni","Raj","abc@gmail.com","abc#123", UserRole.ROLE_HOSPITAL)
        );

        userEntityDao.saveAll(users);
    }
}
