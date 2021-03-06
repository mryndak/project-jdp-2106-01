package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.UserDto;
import com.kodilla.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @PutMapping
    public void blockUser(@RequestParam Long id) {
        userService.updateUserStatus(id);
    }

    @PostMapping("/login")
    public void userLogin(@RequestBody Map<String, String> creds) {
        userService.login(creds);
    }
}
