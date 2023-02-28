package com.pildoraslin.motoservicio.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Moto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moto_id;

    private String marca;
    private String modelo;
    private int usuarioId;

    public Moto(String marca, String modelo, int usuarioId) {
        this.marca = marca;
        this.modelo = modelo;
        this.usuarioId = usuarioId;
    }
}
