package com.proyecto.ed.model;


import com.proyecto.ed.security.model.Rol;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
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
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    private String fecha;
    private String edad;
    private String nombre;
    private String sexo;
    private String pais;
    private String ciudad;
    private String telefono;
    @OneToMany (mappedBy  = "usuario", cascade = CascadeType.ALL)
    private List<Casa> casas;
    @NotNull
    @ManyToMany
    @JoinTable(name = "rol_usuario",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name="rol_id") )
    private Set <Rol>  roles = new HashSet<>();

    public User(@NotNull String email, @NotNull String password, String fecha, String edad, String nombre, String sexo, String pais, String ciudad, String telefono, List<Casa> casas, @NotNull Set<Rol> roles) {
        this.email = email;
        this.password = password;
        this.fecha = fecha;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.casas = casas;
        this.roles = roles;
    }

    public User() {
    }


}