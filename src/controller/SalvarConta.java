package controller;

import beans.Conta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class SalvarConta
{
    public static void salvar(File arquivoContas, int indice) throws IOException
    {
        FileWriter arquivo = new FileWriter(arquivoContas);
        PrintWriter salvar = new PrintWriter(arquivo);

        salvar.println(indice);

        salvar.close();
    }
}
