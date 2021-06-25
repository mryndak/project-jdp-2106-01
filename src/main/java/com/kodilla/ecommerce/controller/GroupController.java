package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        List<GroupDto> rtn = new ArrayList<>();
        GroupDto testGroupDto1 = new GroupDto();
        GroupDto testGroupDto2 = new GroupDto();
        GroupDto testGroupDto3 = new GroupDto();
        testGroupDto1.setId(1);
        testGroupDto2.setId(2);
        testGroupDto3.setId(3);
        testGroupDto1.setName("Test Groups 1");
        testGroupDto2.setName("Test Groups 2");
        testGroupDto3.setName("Test Groups 3");
        rtn.add(testGroupDto1);
        rtn.add(testGroupDto2);
        rtn.add(testGroupDto3);
        return rtn;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Integer groupId) {
        GroupDto groupDto = new GroupDto();
        groupDto.setName("Test One Group");
        groupDto.setId(1);
        return groupDto;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Integer groupId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        GroupDto stub = new GroupDto();
        stub.setId(groupDto.getId());
        stub.setName(groupDto.getName());
        return stub;
    }
}
