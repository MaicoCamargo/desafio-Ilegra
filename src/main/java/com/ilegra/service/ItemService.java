package com.ilegra.service;

import com.ilegra.model.Item;

import java.util.HashSet;
import java.util.Set;

public class ItemService {

    /**
     * realiza o split da string que tem um array de itens
     *
     *  -  para montar a lista de itens foi usado a estrutura de dados Set que não permite adicionar valores duplicados
     * @param itensVenda - string com array de itens
     * @return - lista do objeto itens
     */
    public Set<Item> montaListaItemVenda(String itensVenda) {
        Set<Item> itens = new HashSet<>();
        String itensVenda_subString = itensVenda.substring(1, itensVenda.length() - 1);
        String[] arrayatributosItem = itensVenda_subString.split(",");
        for (String atributos : arrayatributosItem) {
            int idItem = Integer.parseInt(atributos.split("-")[0]);
            int quantidade = Integer.parseInt(atributos.split("-")[1]);
            float preco = Float.parseFloat(atributos.split("-")[2]);
            itens.add(new Item(idItem,quantidade,preco));
        }
        return itens;
    }
}
