package org.github.cleberGraciano.clientes.exception;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String username) {
        super("Usuario já cadastrado para o login "+username);
    }
}
