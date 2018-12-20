package br.ufrpe.bcc.ip2.projeto;

import br.ufrpe.bcc.ip2.projeto.beans.Adicionar;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Executando...");
        Adicionar x = new Adicionar();
        Conta h = x.cadastrar();
        x.adicionarConta(h);
        //Conta conta = new Conta();
        //conta.cadastro();
       // boolean x = Verif.cpfcerto("123.456.789-10");
        Arquivos.criarDiretorio();
        System.out.println("Final do arquivo");
        //System.out.println(x);
        //para poder fazer o login, precisamos verificar algum tipo de array de contas
    }
}
