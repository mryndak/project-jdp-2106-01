package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.UserDto;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {

    //private final UserService userService;
    //private final UserMapper userMapper;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto){
        System.out.println("id: " + userDto.getId() + ", name: " + userDto.getUsername() + " was created");
        return null;
    }



}
