package com.ilegra.model;

public class Cliente {
    private Identificador identificador;
    private String cnpj;
    private String nome;
    private String BusinessArea;

    public Cliente(String cnpj, String nome, String businessArea) {
        this.identificador = Identificador.CLIENTE;
        this.nome = nome;
        this.cnpj = cnpj;
        BusinessArea = businessArea;
    }

    public Identificador getIdentificador() {
        return identificador;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", BusinessArea='" + BusinessArea + '\'' +
                '}';
    }
}
