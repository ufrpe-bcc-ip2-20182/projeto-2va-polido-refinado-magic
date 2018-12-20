package br.ufrpe.bcc.ip2.projeto.controller;

import java.io.File;
import java.io.IOException;

public class ArquivoContas
{
    File arquivoContas;


    public File getArquivoContas()
    {
        setArquivoContas();
        return arquivoContas;
    }

    public String getCaminho()
    {
        return arquivoContas.getPath();
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
        File arquivo = new File(caminho + "\\src\\main\\java\\br\\ufrpe\\bcc\\ip2\\projeto\\arquivo\\Conta.txt");

        this.arquivoContas = arquivo;
    }
}
