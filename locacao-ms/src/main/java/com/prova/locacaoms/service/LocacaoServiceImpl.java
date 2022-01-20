package com.prova.locacaoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prova.locacaoms.clienteHTTP.ClientesFeignClient;
import com.prova.locacaoms.compartilhado.LocacaoDto;
import com.prova.locacaoms.model.Locacao;
import com.prova.locacaoms.repository.LocacaoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoServiceImpl implements LocacaoService {

    @Autowired
    private LocacaoRepository repo;

    @Autowired
    private ClientesFeignClient clientesMsClient;

    @Override
    public LocacaoDto criarLocacao(LocacaoDto locacao) {
        return salvarLocacao(locacao);
    }

    @Override
    public List<LocacaoDto> obterTodas() {
        List<Locacao> locacoes = repo.findAll();

        return locacoes.stream()
            .map(locacao -> new ModelMapper().map(locacao, LocacaoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<LocacaoDto> obterPorId(String id) {
       Optional<Locacao> locacao = repo.findById(id);

        
       if(locacao.isPresent()) {
           LocacaoDto dto = new ModelMapper().map(locacao.get(), LocacaoDto.class);
           dto.setClientes(clientesMsClient.obterClientes(id));
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void apagarLocacao(String id) {
        repo.deleteById(id);
    }

    @Override
    public LocacaoDto atualizarLocacao(String id, LocacaoDto locacao) {
        locacao.setId(id);
        return salvarLocacao(locacao);
    }

    private LocacaoDto salvarLocacao(LocacaoDto locacao) {
        ModelMapper mapper = new ModelMapper();
        Locacao salvarLocacao = mapper.map(locacao, Locacao.class);
        salvarLocacao = repo.save(salvarLocacao);

        return mapper.map(salvarLocacao, LocacaoDto.class);
    }
    
}
