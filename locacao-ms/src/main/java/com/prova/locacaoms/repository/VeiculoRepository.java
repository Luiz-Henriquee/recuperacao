package com.prova.locacaoms.repository;

import com.prova.locacaoms.model.Veiculo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String>{
    
}
