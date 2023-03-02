package com.pildoraslin.usuarioservicio.servicio;

import com.pildoraslin.usuarioservicio.entidades.Usuario;
import com.pildoraslin.usuarioservicio.feigncliente.CarroFeignCliente;
import com.pildoraslin.usuarioservicio.feigncliente.MotoFeignCliente;
import com.pildoraslin.usuarioservicio.modelos.Carro;
import com.pildoraslin.usuarioservicio.modelos.Moto;
import com.pildoraslin.usuarioservicio.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MotoFeignCliente motoFeignCliente;

    @Autowired
    CarroFeignCliente carroFeignCliente;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> dameUsuarios(){
        return usuarioRepositorio.findAll();
    }

    public Usuario dameUsuario(int id){

        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario creaUsuario(@RequestBody Usuario usuario){

       // Usuario usuario1 = usuarioRepositorio.save(usuario);

       // return usuario1;

        return usuarioRepositorio.save(usuario);
    }

    public List<Carro> dameCarros(int usuarioId){

        //List<Carro> carros = restTemplate.getForObject("http://localhost:8081/carros/usuario/" + usuarioId, List.class);
       // List<Carro> carros =  carroFeignCliente.dameCarrosPorUsuarioId(usuarioId);

       // return  carros;
        return carroFeignCliente.dameCarrosPorUsuarioId(usuarioId);
    }

    public List<Moto> dameMotos(int usuarioId){

       List<Moto> motos = restTemplate.getForObject("http://localhost:8092/motos/usuario/" + usuarioId, List.class);


        return  motos;
    }

    public  Carro guardaCarroPorUsuarioId(int usuarioId, Carro carro){

        carro.setUsuarioId(usuarioId);

        Carro carro1 = carroFeignCliente.creaCarro(carro);

        return  carro1;

    }

    public Moto creaMotoPorUsuarioId(int clienteId, Moto moto){

        moto.setUsuarioId(clienteId);

        Moto nuevaMoto = motoFeignCliente.creaMoto(moto);

        return nuevaMoto;
    }


    public Map<String, Object> dameUsuarioVehiculos(int usuarioId){

        Map<String, Object> datos = new HashMap<>();
        Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);

        if(usuario == null){
            datos.put("mensaje", "el usuario no existe intente de nuevo");
            return datos;
        }
        datos.put("usuario", usuario);
        List<Carro> carros = carroFeignCliente.dameCarrosPorUsuarioId(usuarioId);

        if(carros == null || carros.isEmpty()){
            datos.put("carros", "el usuario no tiene carros");
        }else{

            datos.put("carros", carros);
        }

        List<Moto> motos = motoFeignCliente.dameMotosPorUsuarioId(usuarioId);

        //if(motos == null || motos.isEmpty()){
          if(CollectionUtils.isEmpty(motos)){
            datos.put("motos", "el usuario no tiene motos");
        }else{

            datos.put("motos", motos);
        }
        return datos;
    }



}
