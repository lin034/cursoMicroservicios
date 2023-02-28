package com.pildoraslin.motoservicio.repositorio;

import com.pildoraslin.motoservicio.entidad.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepositorio extends JpaRepository<Moto, Integer> {

    public List<Moto> findByUsuarioId(int usuarioId);
}
