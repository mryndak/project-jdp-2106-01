package com.kodilla.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
//    private Long id;
//    private String username;
//    private String status;
//    private int userKey;

    //na bazie diagramu https://snipboard.io/n0ipLV.jpg
    private Long id;
    private String username;
    private String email;
    private String address;
    private String userLogin;
    private boolean userStatus;
    private String password;
//    private CartDto cart;
//    private List<OrderDto> orders;

}
