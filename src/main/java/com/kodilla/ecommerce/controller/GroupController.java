package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.mapper.GroupMapper;
import com.kodilla.ecommerce.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable long id) {
        return groupService.getGroupById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupService.updateGroup(groupDto);
    }
}
