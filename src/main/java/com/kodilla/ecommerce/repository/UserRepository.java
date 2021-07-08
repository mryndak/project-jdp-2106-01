package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

    User getUserByUserLogin(String userLogin);
}

