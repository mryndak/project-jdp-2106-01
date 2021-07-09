package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Token;
import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.dto.UserDto;
import com.kodilla.ecommerce.mapper.UserMapper;
import com.kodilla.ecommerce.repository.TokenRepository;
import com.kodilla.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class UserService {

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.tokenRepository = tokenRepository;
    }

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TokenRepository tokenRepository;

    private final char[] symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final int EXP_TIME = 60;
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    public User saveUser(final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return userRepository.save(user);
    }

    public void updateUserStatus(Long id) {
        User user = userRepository.getUserById(id);
        user.setUserStatus(false);
        userRepository.save(user);
    }

    public void login(Map<String, String> creds) {
        String username = creds.get(USERNAME);
        String password = creds.get(PASSWORD);
        User u = userRepository.getUserByUserLogin(username);

        if (u.getPassword().equals(password)) {
            generateToken(u);
        }
    }

    private void generateToken(User u) {
        Token token = new Token();
        char[] randomizer = new char[10];

        for (int i = 0; i < randomizer.length; i++) {
            int idx = new Random().nextInt(symbols.length);
            char random = symbols[idx];
            randomizer[i] = random;
        }

        token.setToken(randomizer.toString());
        token.setExpirationDate(setExpiration());
        token.setUserId(u.getId());
        tokenRepository.save(token);
    }

    private Date setExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, EXP_TIME);
        return new Date(calendar.getTime().getTime());
    }

}