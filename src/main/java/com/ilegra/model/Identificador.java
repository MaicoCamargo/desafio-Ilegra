package com.ilegra.model;

public enum Identificador {
    VENDEDOR(001),CLIENTE(002),VENDA(003);

    public int id;

    Identificador(int id) {
    }

    public int getId() {
        return id;
    }
}
