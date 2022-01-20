package com.prova.clientems.repository;

import java.util.List;

import com.prova.clientems.model.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	List<Cliente> findByLocacao(String cliente);
    
}
