package com.pildoraslin.usuarioservicio.repositorio;

import com.pildoraslin.usuarioservicio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {


}
