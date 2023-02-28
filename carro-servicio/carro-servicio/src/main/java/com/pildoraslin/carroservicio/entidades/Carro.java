package com.pildoraslin.carroservicio.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carro_id;

    private String marca;
    private String modelo;
    private int usuarioId;

    public Carro(String marca, String modelo, int usuarioId) {
        this.marca = marca;
        this.modelo = modelo;
        this.usuarioId = usuarioId;
    }
}
