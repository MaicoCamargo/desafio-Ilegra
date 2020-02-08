package com.ilegra.model;

public class Venda {
    private int identificador;
    private int id;
    private Item item;
    private Vendedor vendedor;

    public Venda(int identificador, int id, Vendedor vendedor) {
        this.identificador = identificador;
        this.id = id;
        this.vendedor = vendedor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
