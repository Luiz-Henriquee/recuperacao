package com.prova.locacaoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.prova.locacaoms.compartilhado.VeiculoDto;
import com.prova.locacaoms.model.Veiculo;
import com.prova.locacaoms.service.VeiculoService;
import com.prova.locacaoms.view.model.VeiculoModeloRequest;
import com.prova.locacaoms.view.model.VeiculoModeloResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

   
    @PostMapping
    public ResponseEntity<VeiculoModeloResponse> addVeiculo(@RequestBody @Valid VeiculoModeloRequest veiculo) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(veiculo, VeiculoDto.class);
        dto = service.addVeiculo(dto);
        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<VeiculoModeloResponse>> verTodos() {
        List<VeiculoDto> dtos = service.verTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/verPorId/{id}")
    public ResponseEntity<VeiculoModeloResponse> verPorId(@PathVariable String id) {
        Optional<VeiculoDto> veiculo = service.verPorId(id);

        if(veiculo.isPresent()) {
            
            return new ResponseEntity<>(new ModelMapper().map(veiculo.get(), VeiculoModeloResponse.class),HttpStatus.OK);
        
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/atualizarVeiculo/{id}")
    public ResponseEntity<VeiculoModeloResponse> atualizarVeiculo(@PathVariable String id,
        @Valid @RequestBody Veiculo veiculo) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(veiculo, VeiculoDto.class);
        dto = service.atualizarVeiculo(id, dto);

        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.OK);
        
    }

    @DeleteMapping(value="/deletarVeiculo/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable String id) {
        service.excluirVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
}
