package com.ilegra.model;

public enum Identificador {
    VENDEDOR("001"),
    CLIENTE("002"),
    VENDA("003");

    private String id;

    Identificador(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
