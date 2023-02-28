package com.pildoraslin.usuarioservicio.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTamplateConfiguracion {

    @Bean
    public RestTemplate restTemplate(){

        return  new RestTemplate();
    }
}
