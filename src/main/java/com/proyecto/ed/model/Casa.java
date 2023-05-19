package com.proyecto.ed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "casas")


public class Casa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "casa_id")
    private int id;
    private String name;
    private String descripcion;
    private String tipoVenta;
    private String ciudad;
    private String pais;
    private String img;
    private String video;
    private String estrato;
    private String piso;
    private String habitaciones;
    private String area;
    private String parqueadero;
    private String balcon;
    private String antiguedad;
    @ManyToOne()
    @JoinColumn(name="id_user")
    @JsonBackReference
    private User usuario ;


    public Casa() {
    }

}