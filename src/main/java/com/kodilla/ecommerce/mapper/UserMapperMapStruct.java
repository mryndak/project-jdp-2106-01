package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapperMapStruct {
    public abstract User mapToUser(UserDto userDto);

    public abstract UserDto mapToProductDto(User user);

    public abstract List<UserDto> mapToUserDtoList(List<User> users);

}
