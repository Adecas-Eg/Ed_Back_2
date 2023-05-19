package com.proyecto.ed.repository;


import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String name);

}
