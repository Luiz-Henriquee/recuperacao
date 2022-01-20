package com.prova.clientems.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClienteModeloRequest {
    
    @NotBlank(message = "O nome não pode estar em branco")
    @NotEmpty(message = "O nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O cpf não pode estar em branco")
    @NotEmpty(message = "O cpf não pode estar vazio")
    private String cpf;

    @NotBlank(message = "A CNH não pode estar em branco")
    @NotEmpty(message = "A CNH  não pode estar vazia")
    private int numCnh;

    @NotBlank(message = "A data de nascimento não pode estar em branco")
    @NotEmpty(message = "A data de nascimento não pode estar vazio")
    private String dataNascimento;

    @NotBlank(message = "A locação não pode estar em branco")
    @NotEmpty(message = "A locação não pode estar vazio")
    private String locacao;



    public String getLocacao() {
        return locacao;
    }
    public void setLocacao(String locacao) {
        this.locacao = locacao;
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
