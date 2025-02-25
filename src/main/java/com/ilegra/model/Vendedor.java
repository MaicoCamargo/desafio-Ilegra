package com.ilegra.model;

public class Vendedor {
    private Identificador identificador;
    private String cpf;
    private String nome;
    private float salario;

    public Vendedor() {
        this.identificador = Identificador.VENDEDOR;
    }

    public Vendedor(String cpf, String nome, float salario) {
        this.identificador = Identificador.VENDEDOR;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
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

    @Override
    public String toString() {
        return "Vendedor{" +
                "identificador=" + identificador +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                '}';
    }
}
