package com.proyecto.ed.security.model;

import com.proyecto.ed.model.User;
import com.sun.istack.NotNull;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data

public class UsuarioPrincipal implements UserDetails {
    private String email;
    private String password;
    private String fecha;
    private String edad;
    private String nombre;
    private String sexo;
    private String pais;
    private String ciudad;
    private String telefono;

    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(@NotNull String email, @NotNull String password, String fecha, String edad, String nombre, String sexo, String pais, String ciudad, String telefono, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.fecha = fecha;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.authorities = authorities;
    }


    public static UsuarioPrincipal build(User user){
        List<GrantedAuthority> authority=
                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()
                )).collect(Collectors.toList());
        return  new UsuarioPrincipal(user.getEmail(), user.getPassword(), user.getFecha(),user.getEdad(),
                user.getNombre(), user.getSexo(), user.getPais(),user.getCiudad(),user.getTelefono(), authority);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
