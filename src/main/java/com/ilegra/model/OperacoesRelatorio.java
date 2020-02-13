package com.ilegra.model;

import java.util.Set;

public interface OperacoesRelatorio  {
    int calcularQuantidadeClientes(Set<Cliente> clientes);
    int calcularQuantidadeVendedores(Set<Vendedor> vendedores);
    Vendedor calcularPiorVendedor(Set<Venda> vendas);
    Venda descobrirVendaMaisCara(Set<Venda> vendas);
}
