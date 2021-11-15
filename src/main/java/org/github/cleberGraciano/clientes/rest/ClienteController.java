package org.github.cleberGraciano.clientes.rest;

import org.github.cleberGraciano.clientes.model.entity.Cliente;
import org.github.cleberGraciano.clientes.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping()
    public List<Cliente> bucarClientes(){
        return clienteService.buscarClientes();
    }

    @GetMapping("{id}")
    public Cliente buscarClientePorId(@PathVariable Integer id){
        return clienteService
                .buscarClientePorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarClientePorId(@PathVariable Integer id){
        clienteService.deletarCliente(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@Valid @RequestBody Cliente cliente, @PathVariable Integer id){
        clienteService.atualizarCliente(cliente, id);
    }


}
