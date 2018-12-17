package br.ufrpe.bcc.ip2.projeto.arquivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Arquivo
{
    File arquivo;

    public File getArquivo()
    {
        return arquivo;
    }

    public Arquivo()
    {
        File atual = new File(".");
        String caminho = null;
        try {
            caminho = atual.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File arquivo = new File(caminho + "\\arquivo\\arquivo.txt");

        this.arquivo = arquivo;
    }
}
