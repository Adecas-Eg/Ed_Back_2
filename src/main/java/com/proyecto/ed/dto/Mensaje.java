package com.proyecto.ed.dto;

import lombok.Data;

@Data
public class Mensaje {
    public String mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
