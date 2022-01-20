package com.prova.locacaoms.compartilhado;

import java.util.List;

public class LocacaoDto {
    private String id;
    private String idVeiculo;
    private String idCliente;
    private int diasLocacao;
    private List<Cliente> clientes;


    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

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
