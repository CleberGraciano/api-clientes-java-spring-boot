package org.github.cleberGraciano.clientes.rest;

import lombok.RequiredArgsConstructor;
import org.github.cleberGraciano.clientes.model.entity.ServicoPrestado;
import org.github.cleberGraciano.clientes.model.services.ServicoPrestadoService;
import org.github.cleberGraciano.clientes.rest.dto.ServicoPrestadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/services-provided")
public class ServiçoPrestadoController {

    private final ServicoPrestadoService servicoPrestadoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvarServico(@RequestBody @Valid ServicoPrestadoDto servicoPrestadoDto){
        return servicoPrestadoService.salvarServico(servicoPrestadoDto);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisarServico(@RequestParam(value = "nome", required = false, defaultValue = "") String nome, @RequestParam(name = "mes", required = false) Integer mes){
        return servicoPrestadoService.pesquisar(nome, mes);
    }

}
