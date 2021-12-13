package org.github.cleberGraciano.clientes.services;

import lombok.RequiredArgsConstructor;
import org.github.cleberGraciano.clientes.exception.ClienteNaoEncontradoException;
import org.github.cleberGraciano.clientes.model.entity.Cliente;
import org.github.cleberGraciano.clientes.model.entity.ServicoPrestado;
import org.github.cleberGraciano.clientes.model.repository.ClienteRepository;
import org.github.cleberGraciano.clientes.model.repository.ServicoPrestadoRepository;
import org.github.cleberGraciano.clientes.rest.dto.ServicoPrestadoDto;
import org.github.cleberGraciano.clientes.util.BigDecimalConverter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {

    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final ClienteRepository clienteRepository;
    private final BigDecimalConverter bigDecimalConverter;

    public ServicoPrestado salvarServico(ServicoPrestadoDto dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente =
                clienteRepository
                        .findById(idCliente)
                        .orElseThrow(() -> new ClienteNaoEncontradoException(idCliente));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
        return servicoPrestadoRepository.save(servicoPrestado);
    }

    public List<ServicoPrestado> pesquisar(String nome, Integer mes){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }


}
