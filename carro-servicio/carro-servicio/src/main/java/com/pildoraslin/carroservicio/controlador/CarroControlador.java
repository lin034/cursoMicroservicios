package com.pildoraslin.carroservicio.controlador;

import com.pildoraslin.carroservicio.entidades.Carro;
import com.pildoraslin.carroservicio.servicio.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroControlador {

    @Autowired
    CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> dameCarros(){

        List<Carro> carros = carroService.dameCarros();

        if(carros.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return  new ResponseEntity<>(carros, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{carroId}")
    public ResponseEntity<Carro> dameCarro(@PathVariable(name = "carroId") int carroId){

        Carro carro = carroService.dameCarro(carroId);

        if(carro == null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> creaCarro(@RequestBody Carro carro){

        Carro carro1 = carroService.creaCarro(carro);

        return new ResponseEntity<>(carro1, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> dameCarrosPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId){

        List<Carro> carros = carroService.dameCarroPorUsuarioId(usuarioId);
        if(carros.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(carros);
    }
}
