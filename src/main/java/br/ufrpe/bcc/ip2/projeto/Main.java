package br.ufrpe.bcc.ip2.projeto;

import br.ufrpe.bcc.ip2.projeto.arquivo.Arquivo;
import br.ufrpe.bcc.ip2.projeto.arquivo.SalvarArquivo;
import br.ufrpe.bcc.ip2.projeto.beans.Adicionar;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;
import br.ufrpe.bcc.ip2.projeto.beans.Sistema;
import br.ufrpe.bcc.ip2.projeto.controller.Login;
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

        //para poder fazer o login, precisamos verificar algum tipo de array de contas

        Arquivo arquivo = new Arquivo();
        Sistema sistema = new Sistema();
        SalvarArquivo salvar = new SalvarArquivo();
        Adicionar add = new Adicionar();
        add.adicionarConta(sistema);
        salvar.salvar(sistema, arquivo.getArquivo());
        Login.login(sistema);
    }
}
