package br.ufrpe.bcc.ip2.projeto.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ArquivoContas
{
    File arquivoContas;


    public Path getArquivoContas()
    {
        return arquivoContas.toPath();
    }

    public void setArquivoContas()
    {
        File atual = new File(".");
        String caminho = null;
        try {
            caminho = atual.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File arquivo = new File(caminho + "\\arquivo\\Conta.txt");

        this.arquivoContas = arquivo;
    }
}
