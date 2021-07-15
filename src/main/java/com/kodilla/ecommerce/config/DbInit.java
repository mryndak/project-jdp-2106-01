package com.kodilla.ecommerce.config;

import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void initUser() {
        User u = new User();
        u.setId(4L);
        u.setName("name");
        u.setPassword("password");
        u.setUserLogin("username");
        userRepository.save(u);
    }
}
