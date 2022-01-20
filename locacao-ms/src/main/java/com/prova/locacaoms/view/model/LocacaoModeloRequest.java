package com.prova.locacaoms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LocacaoModeloRequest {
 
    @NotBlank(message = "O id do veículo não pode possuir caracteres em branco!")
    @NotEmpty(message = "O id do veículo deve ser preenchido!")
    private String idVeiculo;

    @NotBlank(message = "O id do cliente não pode possuir caracteres em branco!")
    @NotEmpty(message = "O id do cliente deve ser preenchido!")
    private String idCliente;

    @NotBlank(message = "Os dias de locação não podem possuir caracteres em branco!")
    @NotEmpty(message = "Os dias de locação devem ser preenchidos!")
    @Size(min = 1, message = "A locação deve ser de pelo menos um dia!")
    private int diasLocacao;

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
