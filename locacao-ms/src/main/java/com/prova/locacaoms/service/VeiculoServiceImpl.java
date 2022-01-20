package com.prova.locacaoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prova.locacaoms.compartilhado.VeiculoDto;
import com.prova.locacaoms.model.Veiculo;
import com.prova.locacaoms.repository.VeiculoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    @Override
    public VeiculoDto addVeiculo (VeiculoDto veiculo) {
        return salvarVeiculo(veiculo);
    }

    @Override
    public List<VeiculoDto> verTodos() {
        List<Veiculo> veiculos = repo.findAll();

        return veiculos.stream()
            .map(veiculo -> new ModelMapper().map(veiculo, VeiculoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoDto> verPorId(String id) {
        Optional<Veiculo> veiculo = repo.findById(id);

        if(veiculo.isPresent()) {
            return Optional.of(new ModelMapper().map(veiculo.get(), VeiculoDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void excluirVeiculo(String id) {
        repo.deleteById(id);
    }

    @Override
    public VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculo) {
        veiculo.setId(id);
        return salvarVeiculo(veiculo);
    }

    private VeiculoDto salvarVeiculo(VeiculoDto veiculo) {
        ModelMapper mapper = new ModelMapper();
        Veiculo salvarVeiculo = mapper.map(veiculo, Veiculo.class);
        salvarVeiculo = repo.save(salvarVeiculo);

        return mapper.map(salvarVeiculo, VeiculoDto.class);
    }
    
}
