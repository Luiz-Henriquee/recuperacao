package com.prova.locacaoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.prova.locacaoms.compartilhado.LocacaoDto;
import com.prova.locacaoms.model.Locacao;
import com.prova.locacaoms.service.LocacaoService;
import com.prova.locacaoms.view.model.LocacaoModeloRequest;
import com.prova.locacaoms.view.model.LocacaoModeloResponse;
import com.prova.locacaoms.view.model.LocacaoModeloResponseD;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/api/locacao")
public class LocacaoController {
    @Autowired
    private LocacaoService servic;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }
    

    @PostMapping
    public ResponseEntity<LocacaoModeloResponse> criarLocacao(@RequestBody @Valid LocacaoModeloRequest locacao) {
        ModelMapper mapper = new ModelMapper();
        LocacaoDto dto = mapper.map(locacao, LocacaoDto.class);
        dto = servic.criarLocacao(dto);
        return new ResponseEntity<>(mapper.map(dto, LocacaoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<LocacaoModeloResponse>> obterTodas() {
        List<LocacaoDto> dtos = servic.obterTodas();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LocacaoModeloResponse> respo = dtos.stream().map(dto -> mapper.map(dto, LocacaoModeloResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(respo, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<LocacaoModeloResponseD> obterPorId(@PathVariable String id) {
        Optional<LocacaoDto> locacao = servic.obterPorId(id);

        if(locacao.isPresent()) {

            return new ResponseEntity<>(new ModelMapper().map(locacao.get(), LocacaoModeloResponseD.class), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<LocacaoModeloResponse> atualizarLocacao(@PathVariable String id,
        @Valid @RequestBody Locacao locacao) {
        ModelMapper mapper = new ModelMapper();
        LocacaoDto dto = mapper.map(locacao, LocacaoDto.class);
        dto = servic.atualizarLocacao(id, dto);

        return new ResponseEntity<>(mapper.map(dto, LocacaoModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> apagarLocacao(@PathVariable String id) {
        servic.apagarLocacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 


}

