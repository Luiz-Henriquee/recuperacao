package com.prova.clientems.service;

import java.util.List;
import java.util.Optional;

import com.prova.clientems.compartilhado.ClienteDto;

public interface ClienteService {
    
    ClienteDto addCliente (ClienteDto cliente);
    List<ClienteDto> obterTodos();
    Optional<ClienteDto> obterPorId(String id);
    void removerCliente(String id);
    ClienteDto atualizarCliente(String id, ClienteDto cliente);
    List<ClienteDto> obterPorLocacao(String locacao);
}
