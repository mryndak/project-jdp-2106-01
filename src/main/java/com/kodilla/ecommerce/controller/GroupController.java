package com.kodilla.ecommerce.controller;

//import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.dto.GroupDto;
//import com.kodilla.ecommerce.mapper.GroupMapper;
import com.kodilla.ecommerce.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private GroupService groupService;

    @GetMapping
    public List<GroupDto> getGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public GroupDto create(@RequestBody GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }

//    @GetMapping
//    public List<GroupDto> getGroups() {
//        ArrayList<GroupDto> testGetGroups = new ArrayList<>(List.of(new GroupDto(1, "testGetGroups")));
//        log.info("{}", testGetGroups);
//        return testGetGroups;
////        return groupService.getAllGroups();
//    }
//
//    @GetMapping("/{id}")
//    public GroupDto getGroup(@PathVariable long id) {
//        GroupDto test_getGroup = new GroupDto(2, "test getGroup");
//        log.info("{}", test_getGroup);
//        return test_getGroup;
////        return groupService.getGroupById(id);
//    }
//
//    @PostMapping(
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createGroup(@RequestBody GroupDto groupDto) {
//        log.info("{}", groupDto);
////        groupService.createGroup(groupDto);
//    }
//
//    @PatchMapping(
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
//        GroupDto test_updateGroup = new GroupDto(1, "Test updateGroup");
//        log.info("{}", groupDto);
//        return test_updateGroup;
////        return groupService.updateGroup(groupDto);
//    }

}
