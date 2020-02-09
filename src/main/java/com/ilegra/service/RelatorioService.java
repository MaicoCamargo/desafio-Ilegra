package com.ilegra.service;

import com.ilegra.model.*;
import com.ilegra.props.Props;

import java.io.*;
import java.util.Set;

public class RelatorioService {

    private ItemService itemService;
    public void readFile() throws IOException {
        File file = new File(Props.DATA_IN + "infos.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;
        itemService = new ItemService();
        while ((linha = br.readLine()) != null) {
            String[] linhaSplitada;
            linhaSplitada = linha.split("ç");
            readLine(linhaSplitada);
        }
    }

    public void readLine(String[] linha) {

        if (Identificador.VENDEDOR.getId().equals(linha[0])) {
            Vendedor vendedor = new Vendedor(linha[1], linha[2], Float.parseFloat(linha[3]));
        } else if (Identificador.CLIENTE.getId().equals(linha[0])) {
            Cliente cliente = new Cliente(linha[1], linha[2], linha[3]);
        } else if (Identificador.VENDA.getId().equals(linha[0])) {
            Set<Item> itens = itemService.montaListaItemVenda(linha[2]);
            Vendedor vendedor = new Vendedor();
            vendedor.setNome(linha[3]);
            Venda venda = new Venda(Integer.parseInt(linha[1]), itens, vendedor);
            System.out.println(venda);
        } else System.out.println("[erro] indentificador invalido: " + linha[0]);
    }
}
