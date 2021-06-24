package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
public class GroupController {

    @GetMapping
    public GroupDto groupGet() {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(1);
        groupDto.setName("Test Message");
        return groupDto;
    }
}
