package org.github.cleberGraciano.clientes.rest.controller;

import lombok.RequiredArgsConstructor;
import org.github.cleberGraciano.clientes.exception.ClienteNaoEncontradoException;
import org.github.cleberGraciano.clientes.model.entity.ServicoPrestado;
import org.github.cleberGraciano.clientes.services.ServicoPrestadoService;
import org.github.cleberGraciano.clientes.rest.dto.ServicoPrestadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/services-provided")
public class ServicoPrestadoController {

    private final ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvarServico(@RequestBody @Valid ServicoPrestadoDto servicoPrestadoDto){
        try {
            return servicoPrestadoService.salvarServico(servicoPrestadoDto);
        }catch (ClienteNaoEncontradoException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

    @GetMapping
    public List<ServicoPrestado> pesquisarServico(@RequestParam(value = "nome", required = false, defaultValue = "") String nome, @RequestParam(name = "mes", required = false) Integer mes){
        return servicoPrestadoService.pesquisar(nome, mes);
    }

}
