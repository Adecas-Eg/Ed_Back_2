package com.proyecto.ed.repository;

import com.proyecto.ed.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasaRepository  extends JpaRepository<Casa, Integer> {
    Optional<Casa> findByName(String name);
    boolean existsByName(String name);


}
