package org.github.cleberGraciano.clientes.model.repository;

import org.github.cleberGraciano.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
