package com.prova.locacaoms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class VeiculoModeloRequest {
    
    @NotBlank(message = "A marca do veículo não pode possuir caracteres em branco!")
    @NotEmpty(message = "A marca do veículo deve ser preenchida!")
    private String marca;

    @NotBlank(message = "O modelo do veículo não pode possuir caracteres em branco!")
    @NotEmpty(message = "O modelo do veículo deve ser preenchido!")
    private String modelo;

    @NotBlank(message = "O numero de passageiros não pode possuir caracteres em branco!")
    @NotEmpty(message = "O numero de passageiros deve ser preenchido!")
    @Size(min = 1, message = "O carro deve suportar pelo menos uma pessoas!")
    private int numPassageiros;

    @NotBlank(message = "O valor da locação por dia não pode possuir caracteres em branco!")
    @NotEmpty(message = "O valor da locação por dia do veículo deve ser preenchido!")
    @Size(min = 1, message = "O Valor tem que ser maior que 1!")
    private double valorLocacaoDia;

    @NotBlank(message = "O combustível do veículo não pode possuir caracteres em branco!")
    @NotEmpty(message = "O combustível do veículo deve ser preenchido!")
    private String combustível;

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getNumPassageiros() {
        return numPassageiros;
    }
    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }
    public double getValorLocacaoDia() {
        return valorLocacaoDia;
    }
    public void setValorLocacaoDia(double valorLocacaoDia) {
        this.valorLocacaoDia = valorLocacaoDia;
    }
    public String getCombustível() {
        return combustível;
    }
    public void setCombustível(String combustível) {
        this.combustível = combustível;
    }
    
}
