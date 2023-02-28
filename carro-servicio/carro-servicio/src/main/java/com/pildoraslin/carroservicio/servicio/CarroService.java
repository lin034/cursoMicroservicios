package com.pildoraslin.carroservicio.servicio;

import com.pildoraslin.carroservicio.entidades.Carro;
import com.pildoraslin.carroservicio.repositorio.CarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepositorio carroRepositorio;

    public List<Carro> dameCarros(){
        return carroRepositorio.findAll();
    }

    public Carro dameCarro(int id){

        return carroRepositorio.findById(id).orElse(null);
    }

    public Carro creaCarro(@RequestBody Carro carro){

        Carro carro1 = carroRepositorio.save(carro);

        return carro1;
    }

    public List<Carro> dameCarroPorUsuarioId(int usuarioId){

        return carroRepositorio.findByUsuarioId(usuarioId);
    }
}
