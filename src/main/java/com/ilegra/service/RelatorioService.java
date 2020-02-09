package com.ilegra.service;

import com.ilegra.model.Cliente;
import com.ilegra.model.Identificador;
import com.ilegra.model.Venda;
import com.ilegra.model.Vendedor;
import com.ilegra.props.Props;

import java.io.*;

public class RelatorioService {

    public void readFile() throws IOException {
        File file = new File(Props.DATA_IN + "infos.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] linhaSplitada;
            linhaSplitada = linha.split("ç");
            readLine(linhaSplitada);
        }
    }

    public void readLine(String[] linha) {

        if (Identificador.VENDEDOR.getId().equals(linha[0])) {
            Vendedor vendedor = new Vendedor(linha[1], linha[2], Float.parseFloat(linha[3]));
            System.out.println(vendedor.toString());

        } else if (Identificador.CLIENTE.getId().equals(linha[0])) {
            Cliente cliente = new Cliente(linha[1], linha[2], linha[3]);
            System.out.println(cliente.toString());

        } else if (Identificador.VENDA.getId().equals(linha[0])) {
//            new Venda()
            System.out.println("venda");
        } else System.out.println("[erro] indentificador invalido: " + linha[0]);
    }
}
