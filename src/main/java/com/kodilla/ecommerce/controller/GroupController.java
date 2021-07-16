package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<GroupDto> getGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public GroupDto create(@RequestBody GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }
}
