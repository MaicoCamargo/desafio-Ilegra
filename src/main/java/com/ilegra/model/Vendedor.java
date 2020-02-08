package com.ilegra.model;

public class Vendedor {
    private int codigo;
    private String nome;
    private String cpf;
    private float salario;

    public Vendedor(int codigo, String nome, String cpf, float salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
