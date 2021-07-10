package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findAll();

    Group findById(long id);

    Group save(Group group);

    void deleteById(long id);
}
