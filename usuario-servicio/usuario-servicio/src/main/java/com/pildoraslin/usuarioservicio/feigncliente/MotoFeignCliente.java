package com.pildoraslin.usuarioservicio.feigncliente;


import com.pildoraslin.usuarioservicio.modelos.Carro;
import com.pildoraslin.usuarioservicio.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moto-servicio", url = "http://localhost:8082")
@RequestMapping("/motos")
public interface MotoFeignCliente {

    @PostMapping
    public Moto creaMoto(@RequestBody Moto moto);

    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> dameMotosPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId);
}
