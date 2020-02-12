package com.ilegra.model;

import java.util.Set;

public class Relatorio implements OperacoesRelatorio {
    private Set<Cliente> clientes;
    private Set<Vendedor> vendedores;
    private Set<Venda> vendas;

    public Relatorio() {
    }

    public Relatorio(Set<Cliente> clientes, Set<Vendedor> vendedores, Set<Venda> vendas) {
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.vendas = vendas;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Set<Venda> getVendas() {
        return vendas;
    }


    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public int calcularQuantidadeClientes(Set<Cliente> clientes) {
        return clientes.size();
    }

    @Override
    public int calcularQuantidadeVendedores(Set<Vendedor> vendedores) {
        return vendedores.size();
    }

    @Override
    public Vendedor calcularPiorVendedor(Set<Venda> vendas) {
        Vendedor vendedor = null;
        float valor =0;
        float aux =0;
        for (Venda  venda: vendas){
            for (Item item: venda.getItens()){
                aux+=item.getPreco() * item.getQuantidade();
            }
            if (valor ==0){
                valor = aux;
            }
            if (valor >=aux){
                valor = aux;
                vendedor = venda.getVendedor();
            }
            aux =0;
        }
        return vendedor;
    }

    @Override
    public Venda descobrirVendaMaisCara(Set<Venda> vendas) {
        Venda maiorVenda = new Venda();
        float valorMaiorVenda = 0;
        float auxCalcularValorMaiorVenda = 0;
        for (Venda  venda: vendas){
            for (Item item: venda.getItens()){
                auxCalcularValorMaiorVenda+= item.getPreco() * item.getQuantidade();
            }
            if (auxCalcularValorMaiorVenda >= valorMaiorVenda){
                valorMaiorVenda = auxCalcularValorMaiorVenda;
                maiorVenda = venda;
            }
            auxCalcularValorMaiorVenda = 0;
        }
        return maiorVenda;
    }
}
