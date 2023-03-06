package com.pildoraslin.usuarioservicio.feigncliente;

import com.pildoraslin.usuarioservicio.modelos.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "carro-servicio", url = "http://localhost:8081")

@FeignClient(name = "carro-servicio")
@RequestMapping("/carros")
public interface CarroFeignCliente {

    @PostMapping
    public Carro creaCarro(@RequestBody Carro carro);

    @GetMapping("/usuario/{usuarioId}")
    public List<Carro> dameCarrosPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId);


}
