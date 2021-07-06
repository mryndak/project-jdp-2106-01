package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group,Integer> {

    List<Group> findAll();

    Group findAllById(long id);

    Group save(Group group);

    void deleteById( long id);
}
