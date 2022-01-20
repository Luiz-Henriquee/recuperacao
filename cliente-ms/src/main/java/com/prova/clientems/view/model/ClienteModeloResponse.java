package com.prova.clientems.view.model;

public class ClienteModeloResponse {
    private String id;
    private String nome;
    private String cpf;
    private int numCnh;
    private String dataNascimento;
    private String locacao;

    
    public String getLocacao() {
        return locacao;
    }
    public void setLocacao(String locacao) {
        this.locacao = locacao;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getNumCnh() {
        return numCnh;
    }
    public void setNumCnh(int numCnh) {
        this.numCnh = numCnh;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
