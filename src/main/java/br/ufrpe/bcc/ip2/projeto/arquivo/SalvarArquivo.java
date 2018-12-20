package br.ufrpe.bcc.ip2.projeto.arquivo;

import br.ufrpe.bcc.ip2.projeto.beans.Boleto;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;

import java.io.*;
import java.util.ArrayList;

public class SalvarArquivo
{
    public static void salvar(File arquivo, Conta conta)
    {
        FileWriter escritor;
        try
        {
            escritor = new FileWriter(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter escrever = null;

        try
        {
            escrever = new PrintWriter(arquivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
