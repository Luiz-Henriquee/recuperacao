package com.prova.clientems.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.prova.clientems.compartilhado.ClienteDto;
import com.prova.clientems.service.ClienteService;
import com.prova.clientems.view.model.ClienteModeloA;
import com.prova.clientems.view.model.ClienteModeloRequest;
import com.prova.clientems.view.model.ClienteModeloResponse;

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
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteModeloResponse> addCliente(@RequestBody @Valid ClienteModeloRequest Cliente) {
        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(Cliente, ClienteDto.class);
        dto = service.addCliente(dto);
        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteModeloResponse>> obterTodos() {
        List<ClienteDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ClienteModeloResponse> resp = dtos.stream().map(dto -> mapper.map(dto, ClienteModeloResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @GetMapping(value="/{locacao}/lista")
    public ResponseEntity<List<ClienteModeloResponse>> obterPorLocacao(@PathVariable String locacao) {
        List<ClienteDto> dtos = service.obterPorLocacao(locacao);

        if(dtos.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        ModelMapper mapper = new ModelMapper();
        List<ClienteModeloResponse> resp = dtos.stream().map(dto -> mapper.map(dto, ClienteModeloResponse.class)) .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ClienteModeloResponse> obterPorId(@PathVariable String id) {
        Optional<ClienteDto> Cliente = service.obterPorId(id);

        if(Cliente.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Cliente.get(), ClienteModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ClienteModeloResponse> atualizarCliente(@PathVariable String id, @Valid @RequestBody ClienteModeloA Cliente) 
    {

        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(Cliente, ClienteDto.class);
        dto = service.atualizarCliente(id, dto);

        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.OK);

    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable String id) {
        service.removerCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

