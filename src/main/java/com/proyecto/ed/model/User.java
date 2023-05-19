package com.proyecto.ed.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_user")
    private int id;
    private String email;
    private String password;
    private String fecha;
    private String edad;
    private String nombre;
    private String sexo;
    private String pais;
    private String ciudad;
    private String telefono;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Casa> casas;


    public User() {
    }


}