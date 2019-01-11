package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class LerConta
{
    public static int ler(File arquivoContas) throws IOException
    {
        FileReader arquivo = new FileReader(arquivoContas);
        BufferedReader ler = new BufferedReader(arquivo);
        int indice = Integer.parseInt(ler.readLine());

        arquivo.close();

        return indice;
    }
}
