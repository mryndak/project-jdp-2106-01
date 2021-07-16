package com.kodilla.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {

    private long id;
    private String name;

}
