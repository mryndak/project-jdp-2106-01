package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Group;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    private ProductRepository productRepository;

    @Autowired
    public GroupMapper(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Group mapToGroup(GroupDto groupDto) {
        List<Product> products = productRepository.findAll().stream()
                .filter(e -> e.getGroup().getId() == groupDto.getId())
                .collect(Collectors.toList());
        return new Group(groupDto.getId(),groupDto.getName(),products);
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
