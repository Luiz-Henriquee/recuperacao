package com.prova.locacaoms.view.model;

public class VeiculoModeloResponse {
    private String id;
    private String marca;
    private String modelo;
    private int numPassageiros;
    private double valorLocacaoDia;
    private String combustível;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
