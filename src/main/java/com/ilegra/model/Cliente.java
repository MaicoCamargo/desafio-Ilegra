package com.ilegra.model;

public class Cliente {
    private int codigo;
    private String nome;
    private String cnpj;
    private String BusinessArea;

    public Cliente(int codigo, String nome, String cnpj, String businessArea) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
        BusinessArea = businessArea;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getBusinessArea() {
        return BusinessArea;
    }

    public void setBusinessArea(String businessArea) {
        BusinessArea = businessArea;
    }
}
