package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token, Long> {

}
