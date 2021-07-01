package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {
    //private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        System.out.println("id: " + userDto.getId() + ", name: " + userDto.getUsername() + " was created");
//        userService.addUser(userMapper.DtoToEntity(userDto)) mapper powinien być static
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity blockUser(@RequestBody String id) {
//        userService.blockUserById(Long.parseLong(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity userLogin(@RequestBody Map<String, String> creds) {
        String username = creds.get("username");
        String password = creds.get("password");
//        userService.login(username, password); metoda login przypisuje token działający określonu czas - połączone w bazie po kluczu obcym iduser
        return new ResponseEntity(HttpStatus.OK);
    }
}
