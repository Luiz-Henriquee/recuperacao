package com.prova.locacaoms.model;
//id da locação, id do veículo, id do cliente, número de dias de locação;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Locacao {   
    @Id
    private String id;
    private String idVeiculo;
    private String idCliente;
    private int diasLocacao;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public int getDiasLocacao() {
        return diasLocacao;
    }
    public void setDiasLocacao(int diasLocacao) {
        this.diasLocacao = diasLocacao;
    }
   
}