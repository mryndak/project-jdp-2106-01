package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.mapper.GroupMapper;
import com.kodilla.ecommerce.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;


    public List<GroupDto> getAllGroups() {
        return groupMapper.mapToGroupDtoList(repository.findAll());
    }

    public GroupDto getGroupById(long id) {
        return groupMapper.mapToGroupDto(repository.findById(id));
    }

    public GroupDto createGroup(GroupDto groupDto) {
        return groupMapper.mapToGroupDto(repository.save(groupMapper.mapToGroup(groupDto)));
    }

    public GroupDto updateGroup(GroupDto groupDto) {
        return groupMapper.mapToGroupDto(repository.save(groupMapper.mapToGroup(groupDto)));
    }

    @Transactional
    public void deleteGroup(long id) {
        repository.deleteById(id);
    }
}
