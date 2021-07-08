package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.mapper.GroupMapper;
import com.kodilla.ecommerce.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private GroupService groupService;

        @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
            log.info("{}","get groups");
            return new ArrayList<>(List.of(new GroupDto(1,"test get groups")));
//        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable long id) {
            log.info("{}" , "test group");
            return new GroupDto(2,"test Get group");
//        return groupService.getGroupById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
//        groupService.createGroup(groupDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {

        return new GroupDto(5,"test update group");
//        return groupService.updateGroup(groupDto);
    }
///////////////////////////////////////////////////////////////////////
    /*
    Ponizej znajduje się skrócona implementacja tych samych endpointów mógłby mi ktos powiedziec dla czego nie działa ?
    */
//    @GetMapping("/{getGroups}")
//    public List<GroupDto> getGroups()
//    {
//        ArrayList<GroupDto> testGetGroups = new ArrayList<>(List.of(new GroupDto(1, "testGetGroups")));
//        log.info("{}",testGetGroups);
//        return testGetGroups;
////        return groupService.getAllGroups();
//    }

//    @GetMapping("/{id}")
//    public GroupDto getGroup(@PathVariable long id) {
//        GroupDto test_getGroup = new GroupDto(2, "test getGroup");
//        log.info("{}",test_getGroup);
//        return test_getGroup;
////        return groupService.getGroupById(id);
//    }
//
//    @PostMapping(
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createGroup(@RequestBody GroupDto groupDto) {
//        log.info("{}",groupDto);
////        groupService.createGroup(groupDto);
//    }
//
//    @PatchMapping( value = "/{update}",
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
//        GroupDto test_updateGroup = new GroupDto(1, "Test updateGroup");
//        log.info("{}", groupDto);
//        return test_updateGroup;
////        return groupService.updateGroup(groupDto);
//    }

}
