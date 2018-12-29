package br.ufrpe.bcc.ip2.projeto;

import br.ufrpe.bcc.ip2.projeto.arquivo.Arquivo;
import br.ufrpe.bcc.ip2.projeto.arquivo.SalvarArquivo;
import br.ufrpe.bcc.ip2.projeto.beans.Adicionar;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;
import br.ufrpe.bcc.ip2.projeto.beans.Sistema;
import br.ufrpe.bcc.ip2.projeto.util.Getters;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Executando...");
        //SimpleDateFormat k = new SimpleDateFormat("dd/MM/yyyy");
        //Adicionar x = new Adicionar();
        //Conta h = x.cadastrar();

        //Conta conta = new Conta();
        //conta.cadastro();
       // boolean x = Verif.cpfcerto("123.456.789-10");
        //Arquivos.criarDiretorio();
        //System.out.println("Final do arquivo");
        //System.out.println(x);
        //para poder fazer o login, precisamos verificar algum tipo de array de contas

        Arquivo arquivo = new Arquivo();
        Sistema sistema = new Sistema();
        SalvarArquivo salvar = new SalvarArquivo();
        Adicionar add = new Adicionar();
        Conta teste = add.cadastrar();
        sistema.addContas(teste);
        salvar.salvar(sistema, arquivo.getArquivo());
    }
}
