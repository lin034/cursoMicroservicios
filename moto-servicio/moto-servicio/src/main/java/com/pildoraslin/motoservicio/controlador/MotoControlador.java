package com.pildoraslin.motoservicio.controlador;

import com.pildoraslin.motoservicio.entidad.Moto;
import com.pildoraslin.motoservicio.servicio.MotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoControlador {

    @Autowired
    MotoServicio motoServicio;

    @GetMapping
    public ResponseEntity<List<Moto>> dameMotos(){

        List<Moto> motos = motoServicio.dameMotos();

        if(motos.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return  new ResponseEntity<>(motos, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{motoId}")
    public ResponseEntity<Moto> dameMoto(@PathVariable(name = "motoId") int motoId){

        Moto moto = motoServicio.dameMoto(motoId);

        if(moto == null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> creaMoto(@RequestBody Moto moto){

        Moto moto1 = motoServicio.creaMoto(moto);

        return new ResponseEntity<>(moto1, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> dameMotosPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId){

        List<Moto> motos = motoServicio.dameMotosPorUsuarioId(usuarioId);
        if(motos.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(motos);
    }

}
