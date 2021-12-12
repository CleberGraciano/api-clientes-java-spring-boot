package org.github.cleberGraciano.clientes.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.cleberGraciano.clientes.model.entity.enuns.TipoUsuario;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, name = "login") //Nome de usuario é unico na tabela
    private String username;

    @Column(name = "senha")
    private String password;
    
    private TipoUsuario tipoUsuario;
}
