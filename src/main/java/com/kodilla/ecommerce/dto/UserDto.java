package com.kodilla.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String userLogin;
    private boolean userStatus;
    private String password;
    private List<OrderDto> orderDtos;
}
