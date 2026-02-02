package com.study.jwt.repository;


import com.study.jwt.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {

   Optional<ClientUser> findByUsername(String username);



}
