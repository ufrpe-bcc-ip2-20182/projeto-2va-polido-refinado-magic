package controller;

import java.io.File;
import java.io.IOException;

public class ArquivoContas
{
    File arquivo;

    public File getArquivo()
    {
        return arquivo;
    }

    public ArquivoContas()
    {
        File atual = new File(".");
        String caminho = null;
        try {
            caminho = atual.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File arquivo = new File(caminho+"\\arquivo\\Conta.txt");
        this.arquivo = arquivo;
    }
}
