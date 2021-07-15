package com.kodilla.ecommerce.entities;

import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserEntityTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void testUserRepo() {
        testEntityManager.persist(new User(
                4L,
                "testName",
                "testEmail",
                "testAddress",
                "testLogin",
                true,
                "testPassword"
        ));

        User u = userRepository.getUserById(1L);
        assertEquals(1L, u.getId());
    }

}
