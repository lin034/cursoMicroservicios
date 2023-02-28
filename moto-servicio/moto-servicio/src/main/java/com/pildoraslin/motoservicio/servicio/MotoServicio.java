package com.pildoraslin.motoservicio.servicio;

import com.pildoraslin.motoservicio.entidad.Moto;
import com.pildoraslin.motoservicio.repositorio.MotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServicio {

    @Autowired
    MotoRepositorio motoRepositorio;


    public List<Moto> dameMotos(){

        return motoRepositorio.findAll();
    }

    public Moto dameMoto(int motoId){

        return motoRepositorio.findById(motoId).orElse(null);
    }

    public Moto creaMoto(Moto moto){

        Moto moto1 = motoRepositorio.save(moto);

        return moto1;
    }

    public List<Moto> dameMotosPorUsuarioId(int usuarioId){

        List<Moto> motos = motoRepositorio.findByUsuarioId(usuarioId);

        return motos;
    }

}
