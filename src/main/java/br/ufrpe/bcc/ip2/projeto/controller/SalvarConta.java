package br.ufrpe.bcc.ip2.projeto.controller;


import br.ufrpe.bcc.ip2.projeto.Conta;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class SalvarConta
{
    public static void salvar(Conta conta, File arquivoContas) throws IOException
    {
        FileWriter arquivo = new FileWriter(arquivoContas);
        PrintWriter salvar = new PrintWriter(arquivo);

        salvar.println(conta.getLogin());
        salvar.print(conta.getSenha());


        salvar.close();
    }
}
