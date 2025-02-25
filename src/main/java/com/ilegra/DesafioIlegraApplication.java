package com.ilegra;

import com.ilegra.props.Props;
import com.ilegra.service.RelatorioService;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Date;

@SpringBootApplication
public class DesafioIlegraApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioIlegraApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            /*
                monitorando o diretório o diretório a cada 10 seg.
            *   - um evento é gerado toda vez que eu arquivo for criado, removido ou deletado.
            *   - quando for criado ou modificado a aplicacação gera um relatório do arquivo e salva no direorio data/out
            * */
            FileAlterationObserver observer = new FileAlterationObserver(Props.DATA_IN);
            FileAlterationMonitor monitor = new FileAlterationMonitor(Long.parseLong("10000"));
            FileAlterationListener listener = new FileAlterationListenerAdaptor() {
                @Override
                public void onFileCreate(File file) {
                    System.out.println("arquivo criado");
                    new RelatorioService().gerarRelatorio(String.valueOf(file), "criado", "Relatorio_"+ new Date());

                }

                @Override
                public void onFileDelete(File file) {
                    // code for processing deletion event
                    System.out.println("arquivo deletado: "+ file);
                }

                @Override
                public void onFileChange(File file) {
                    System.out.println("arquivo modificado");
                    new RelatorioService().gerarRelatorio(String.valueOf(file), "modificado", "Relatorio_"+ new Date());
                }
            };
            observer.addListener(listener);
            monitor.addObserver(observer);
            monitor.start();
        };
    }

}
/*
								Prova para Desenvolvedor
	Objetivo da prova:

		O objetivo da prova é testarmos suas habilidades em desenvolvimento de software. Iremos
		avaliar mais do que o funcionamento da solução proposta, avaliaremos a sua abordagem, a
		sua capacidade analítica, boas práticas de engenharia de software, performance e
		escalabilidade da solução.

	Descrição:

		Criar um sistema de análise de dados de venda que irá importar lotes de arquivos e produzir
		um relatório baseado em informações presentes no mesmo.
		Existem 3 tipos de dados dentro dos arquivos e eles podem ser distinguidos pelo seu
		identificador que estará presente na primeira coluna de cada linha, onde o separador de
		colunas é o caractere “ç”.

		Dados do vendedor
		Os dados do vendedor possuem o identificador 001 e seguem o seguinte formato:
		001çCPFçNameçSalary

		Dados do cliente
		Os dados do cliente possuem o identificador 002 e seguem o seguinte formato:
		002çCNPJçNameçBusiness Area

		Dados de venda
		Os dados de venda possuem o identificador 003 e seguem o seguinte formato:
		003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

		Exemplo de conteúdo total do arquivo:
			001ç1234567891234çPedroç50000
			001ç3245678865434çPauloç40000.99
			002ç2345675434544345çJose da SilvaçRural
			002ç2345675433444345çEduardo PereiraçRural
			003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
			003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

		O sistema deverá ler continuamente todos os arquivos dentro do diretório padrão
		HOMEPATH/data/in e colocar o arquivo de saída em HOMEPATH/data/out.
		No arquivo de saída o sistema deverá possuir os seguintes dados:

			• Quantidade de clientes no arquivo de entrada
			• Quantidade de vendedores no arquivo de entrada
			• ID da venda mais cara
			• O pior vendedor

		Requisitos técnicos
			• O sistema deve rodar continuamente e capturar novos arquivos assim que eles sejam inseridos no diretório padrão.
			• Você tem total liberdade para escolher qualquer biblioteca externa se achar necessário.
*/