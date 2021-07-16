package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.dto.GroupDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupMapper {

    public Group mapToGroup(GroupDto groupDto) {
        return Group.builder()
                .id(groupDto.getId())
                .name(groupDto.getName())
                .build();
    }

    public GroupDto mapToGroupDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .build();
    }

    public List<GroupDto> mapToGroupDtoList(List<Group> groups) {
        List<GroupDto> groupDtos = new ArrayList<>();
        for (Group group : groups) {
            groupDtos.add(mapToGroupDto(group));
        }
        return groupDtos;
    }
}
