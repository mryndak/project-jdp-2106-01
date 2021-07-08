package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.dto.GroupDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(groupDto.getId(), groupDto.getName());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(), group.getName());
    }

    public List<GroupDto> mapToGroupDtoList(List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }

    public List<Group> mapToGroupList(List<GroupDto> groupDtoList) {
        return groupDtoList.stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList());
    }
}
