package com.prova.locacaoms.service;

import java.util.List;
import java.util.Optional;

import com.prova.locacaoms.compartilhado.VeiculoDto;

public interface VeiculoService {

    VeiculoDto addVeiculo(VeiculoDto veiculo);
    List<VeiculoDto> verTodos();
    Optional<VeiculoDto> verPorId(String id);
    void excluirVeiculo(String id);
    VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculo);
    
}
