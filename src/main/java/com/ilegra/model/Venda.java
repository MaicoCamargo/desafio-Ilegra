package com.ilegra.model;

import java.util.List;
import java.util.Set;

public class Venda {

    private Identificador identificador;
    private int id;
    private Set<Item> itens;
    private Vendedor vendedor;

    public Venda(int id, Set<Item> itens, Vendedor vendedor) {
        this.identificador = Identificador.VENDA;
        this.id = id;
        this.itens = itens;
        this.vendedor = vendedor;
    }

    public Identificador getIdentificador() {
        return identificador;
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

    @Override
    public String toString() {
        return "Venda{" +
                "identificador=" + identificador +
                ", id=" + id +
                ", itens=" + itens +
                ", vendedor=" + vendedor +
                '}';
    }
}
