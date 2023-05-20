package com.proyecto.ed.security.repository;

import com.proyecto.ed.model.User;
import com.proyecto.ed.security.enums.RolNombre;
import com.proyecto.ed.security.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
