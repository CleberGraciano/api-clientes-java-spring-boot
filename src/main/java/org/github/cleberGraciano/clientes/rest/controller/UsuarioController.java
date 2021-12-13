package org.github.cleberGraciano.clientes.rest.controller;

import org.github.cleberGraciano.clientes.exception.UsuarioCadastradoException;
import org.github.cleberGraciano.clientes.model.entity.Usuario;
import org.github.cleberGraciano.clientes.services.UsuarioDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioDetailService usuarioDetailService;

    @Autowired
    public UsuarioController(UsuarioDetailService usuarioDetailService) {
        this.usuarioDetailService = usuarioDetailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        try {

            usuarioDetailService.salvar(usuario);

        }catch (UsuarioCadastradoException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }
}
