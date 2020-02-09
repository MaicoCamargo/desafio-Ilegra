package com.ilegra.model;

public class Venda {

    private Identificador identificador;
    private int id;
    private Item item;
    private Vendedor vendedor;

    public Venda(int id, Item item, Vendedor vendedor) {
        this.identificador = Identificador.VENDA;
        this.id = id;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
                ", item=" + item +
                ", vendedor=" + vendedor +
                '}';
    }
}
