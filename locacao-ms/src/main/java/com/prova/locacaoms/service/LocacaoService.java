package com.prova.locacaoms.service;

import java.util.List;
import java.util.Optional;

import com.prova.locacaoms.compartilhado.LocacaoDto;

public interface LocacaoService {

    LocacaoDto criarLocacao(LocacaoDto locacao);
    List<LocacaoDto> obterTodas();
    Optional<LocacaoDto> obterPorId(String id);
    void apagarLocacao(String id);
    LocacaoDto atualizarLocacao(String id, LocacaoDto locacao);
    
}
