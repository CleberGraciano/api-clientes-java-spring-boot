package org.github.cleberGraciano.clientes.model.repository;

import org.github.cleberGraciano.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
