package org.github.cleberGraciano.clientes.services;

import org.github.cleberGraciano.clientes.model.entity.Cliente;
import org.github.cleberGraciano.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> buscarClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Integer id){
        return repository.findById(id);
    }

    public void deletarCliente(Integer id){
          buscarClientePorId(id)
                .map(cliente ->{
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public void atualizarCliente(Cliente clienteAtualizado, Integer id){
        buscarClientePorId(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
           return repository.save(cliente);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
