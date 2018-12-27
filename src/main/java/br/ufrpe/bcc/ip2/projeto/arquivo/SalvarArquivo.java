package br.ufrpe.bcc.ip2.projeto.arquivo;

import br.ufrpe.bcc.ip2.projeto.beans.Boleto;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;

import java.io.*;
import java.util.ArrayList;

public class SalvarArquivo //Essa classe tem a função de criar o arquivo dentro dos diretórios
{
    public static void salvar(File arquivo, Conta conta)
    {
        FileWriter escritor;
        try
        {
            escritor = new FileWriter(arquivo, true); //escritor recebe o arquivo passado no argumento da função
        } catch (IOException e) {
            e.printStackTrace(); //printa o erro
        }
        PrintWriter escrever = null;

        try
        {
            escrever = new PrintWriter(arquivo); //escrever recebe a mesma coisa que escritor
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //printa o erro
        }
        escrever.println("<NOVA-CONTA>");
        escrever.println(conta.getLogin());
        escrever.println(conta.getSenha());
        escrever.println(conta.getNome());
        escrever.println(conta.getCpf());
        escrever.println(conta.getDatadenascimento());
        escrever.println(conta.getDataDeCriacao());
        escrever.println(conta.isStatus());
        escrever.println(conta.getSaldo());

        ArrayList<Boleto> aux = conta.getBoletos();
        for (int i = 0; i < aux.size(); i++)
        {
            escrever.println("<NOVO-BOLETO>");
            escrever.println(aux.get(i));
            escrever.println("<FIM-BOLETO>");
        }
        escrever.println("<FIM-CONTA>");
    }
}
