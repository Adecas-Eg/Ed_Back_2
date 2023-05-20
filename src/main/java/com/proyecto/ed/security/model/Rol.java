package com.proyecto.ed.security.model;

import com.proyecto.ed.security.enums.RolNombre;

import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
