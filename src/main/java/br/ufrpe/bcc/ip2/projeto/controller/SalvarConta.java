package br.ufrpe.bcc.ip2.projeto.controller;


import br.ufrpe.bcc.ip2.projeto.Conta;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public abstract class SalvarConta
{
    public static void salvar(Conta conta, Path caminho) throws IOException
    {
        File arquivoContas = new File(caminho.toString());
        FileWriter arq = new FileWriter(arquivoContas.getName());
        PrintWriter salvar = new PrintWriter(arq);

        salvar.println(conta.getLogin());
        salvar.print(conta.getSenha());


        salvar.close();
    }
}
