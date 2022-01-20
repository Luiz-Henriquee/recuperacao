package com.prova.clientems.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prova.clientems.compartilhado.ClienteDto;
import com.prova.clientems.model.Cliente;
import com.prova.clientems.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    @Override
    public ClienteDto addCliente(ClienteDto cliente) {
        return salvarCliente (cliente);
    }

    @Override
    public List<ClienteDto> obterTodos() {
        List<Cliente> clientes = repo.findAll();

        return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDto.class)).collect(Collectors.toList());

    }

    @Override
    public Optional<ClienteDto> obterPorId(String id) {
        Optional<Cliente> cliente = repo.findById(id);

       if(cliente.isPresent()) {

           return Optional.of(new ModelMapper().map(cliente.get(), ClienteDto.class));

       }

       return Optional.empty();
    }

    @Override
    public List<ClienteDto> obterPorLocacao(String locacao) {
        List<Cliente> clientes = repo.findByLocacao(locacao);

        return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDto.class)).collect(Collectors.toList());

    }

    @Override
    public void removerCliente(String id) {
        repo.deleteById(id);
    }

    @Override
    public ClienteDto atualizarCliente(String id, ClienteDto cliente) {
        cliente.setId(id);
        return salvarCliente(cliente);
    }

    private ClienteDto salvarCliente( ClienteDto cliente) {
        ModelMapper mapper = new ModelMapper();
        Cliente clientes = mapper.map(cliente, Cliente.class);
        clientes = repo.save(clientes);

        return mapper.map(clientes, ClienteDto.class);
    }
    
}
