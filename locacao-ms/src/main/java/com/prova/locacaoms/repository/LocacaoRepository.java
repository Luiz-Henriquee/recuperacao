package com.prova.locacaoms.repository;

import com.prova.locacaoms.model.Locacao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends MongoRepository<Locacao, String>{
    
}
