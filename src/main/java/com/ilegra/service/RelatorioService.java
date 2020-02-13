package com.ilegra.service;

import com.ilegra.model.*;
import com.ilegra.props.Props;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RelatorioService {

    /**
     * le o arquivo e transforma as informações em objetos
     * @param path - caminho e nome do arquivo
     * @return - objeto relatório com as informações do arquivo
     * @throws IOException - exceção caso ocorra um erro ao ler o arquivo
     */
    public Relatorio readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;
        ItemService itemService = new ItemService();

        Set<Vendedor> vendedores = new HashSet<>();
        Set<Cliente> clientes = new HashSet<>();
        Set<Venda> vendas = new HashSet<>();
        Relatorio relatorio = new Relatorio();

        while ((linha = br.readLine()) != null) {
            String[] linhaSplitada;
            linhaSplitada = linha.split("ç");

            if (Identificador.VENDEDOR.getId().equals(linhaSplitada[0])) {
                Vendedor vendedor = new Vendedor(linhaSplitada[1], linhaSplitada[2], Float.parseFloat(linhaSplitada[3]));
                vendedores.add(vendedor);
            }
            else if (Identificador.CLIENTE.getId().equals(linhaSplitada[0])) {
                Cliente cliente = new Cliente(linhaSplitada[1], linhaSplitada[2], linhaSplitada[3]);
                clientes.add(cliente);
            }
            else if (Identificador.VENDA.getId().equals(linhaSplitada[0])) {
                Set<Item> itens = itemService.montaListaItemVenda(linhaSplitada[2]);
                Vendedor vendedor = new Vendedor();
                vendedor.setNome(linhaSplitada[3]);
                Venda venda = new Venda(Integer.parseInt(linhaSplitada[1]), itens, vendedor);
                vendas.add(venda);
            }
            else System.out.println("[erro] indentificador invalido: " + linhaSplitada[0]);

            relatorio.setClientes(clientes);
            relatorio.setVendedores(vendedores);
            relatorio.setVendas(vendas);
        }
        return relatorio;
    }

    /*
    * escreve os dados do relatório em um arquivo e salva no diretório data/out
    * */

    /**
     *
     * @param pathArquivo - caminho do arquivo e nome que deve ser lido para gerar o relatório
     * @param operacao - o que o arquivo foi criado ou modificado
     * @param nomeRelatorio - nome que o relatorio criado deve ter
     */
    public void gerarRelatorio(String pathArquivo, String operacao,String nomeRelatorio) {
        try {
            Relatorio relatorio = readFile(pathArquivo);
            System.out.println("Numero de vendedores: "+ relatorio.calcularQuantidadeVendedores(relatorio.getVendedores()));
            System.out.println("Numero de clientes: "+ relatorio.calcularQuantidadeClientes(relatorio.getClientes()));
            System.out.println("Venda mais cara: "+ "[id:" +relatorio.descobrirVendaMaisCara(relatorio.getVendas()).getId()+"]");
            System.out.println("Pior vendedor: "+ relatorio.calcularPiorVendedor(relatorio.getVendas()).getNome());

            FileWriter arquivo;
            arquivo = new FileWriter(new File(Props.DATA_OUT + nomeRelatorio + new Date()));
            PrintWriter gravarArq = new PrintWriter(arquivo);

            gravarArq.printf("#-- Relatório venda - Desafio Ilegra | Maico Camargo --#\n");
            gravarArq.printf("    --Dir:"+pathArquivo+"\n");
            gravarArq.printf("    --Arquivo:"+operacao+"\n");
            gravarArq.printf("          Numero de vendedores: "+ relatorio.calcularQuantidadeVendedores(relatorio.getVendedores())+"\n");
            gravarArq.printf("          Numero de clientes: "+ relatorio.calcularQuantidadeClientes(relatorio.getClientes())+"\n");
            gravarArq.printf("          venda mais cara: "+ "[id:" +relatorio.descobrirVendaMaisCara(relatorio.getVendas()).getId()+"]"+"\n");
            gravarArq.printf("          Pior vendedor: "+ relatorio.calcularPiorVendedor(relatorio.getVendas()).getNome()+"\n");
            gravarArq.printf("#------------------------END--------------------------#");
            arquivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
