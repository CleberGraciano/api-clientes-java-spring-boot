package org.github.cleberGraciano.clientes.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(Integer id) {
        super("Cliente não encontrado com o Id: "+id);
    }
}
