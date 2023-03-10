package com.pildoraslin.usuarioservicio.controlador;

import com.pildoraslin.usuarioservicio.entidades.Usuario;
import com.pildoraslin.usuarioservicio.modelos.Carro;
import com.pildoraslin.usuarioservicio.modelos.Moto;
import com.pildoraslin.usuarioservicio.repositorio.UsuarioRepositorio;
import com.pildoraslin.usuarioservicio.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public ResponseEntity<List<Usuario>> dameUsuarios(){

        List<Usuario> usuarios = usuarioService.dameUsuarios();

        if(usuarios.isEmpty()){

            return ResponseEntity.noContent().build();
        }

        return  new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> dameUsuario(@PathVariable(name = "usuarioId") int usuarioId){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);

        if(usuario == null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> creaUsuario(@RequestBody Usuario usuario){

        Usuario usuario1 = usuarioService.creaUsuario(usuario);

        return new ResponseEntity<>(usuario1, HttpStatus.CREATED);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> dameCarros(@PathVariable(name = "usuarioId") int usuarioId){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);
        if(usuario == null){

            return  ResponseEntity.notFound().build();
        }

        List<Carro> carros = usuarioService.dameCarros(usuarioId);

        if(carros == null || carros.isEmpty()){

            ResponseEntity.noContent().build();
        }

        return  new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> dameMotos(@PathVariable(name = "usuarioId") int usuarioId){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);
        if(usuario == null){

            return  ResponseEntity.notFound().build();
        }

        List<Moto> motos = usuarioService.dameMotos(usuarioId);

        return  ResponseEntity.ok(motos);
    }

    @PostMapping("/carros/{usuarioId}")
    public ResponseEntity<Carro> guardaCarroPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId, @RequestBody Carro carro){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);
        if(usuario == null){

            return ResponseEntity.notFound().build();
        }

        Carro carro1 = usuarioService.guardaCarroPorUsuarioId(usuarioId, carro);

        return new ResponseEntity<>(carro1, HttpStatus.ACCEPTED);
    }

    @PostMapping("/motos/{usuarioId}")
    public ResponseEntity<Moto> creaMotoPorUsuarioId(@PathVariable(name = "usuarioId") int usuarioId, @RequestBody Moto moto){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);
        if(usuario == null){

            return ResponseEntity.notFound().build();
        }

        Moto moto1 = usuarioService.creaMotoPorUsuarioId(usuarioId, moto);

        return new ResponseEntity<>(moto1, HttpStatus.CREATED);

    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> dameVehiculosPorId(@PathVariable(name = "usuarioId") int usuarioId){

        Usuario usuario = usuarioService.dameUsuario(usuarioId);
        if(usuario == null){

            return ResponseEntity.notFound().build();
        }

        Map<String, Object> vehiculosUsuario= usuarioService.dameUsuarioVehiculos(usuarioId);

        return  ResponseEntity.ok(vehiculosUsuario);
    }

}
