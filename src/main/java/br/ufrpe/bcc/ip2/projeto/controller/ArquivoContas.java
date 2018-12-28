package br.ufrpe.bcc.ip2.projeto.controller;

import java.io.File;
import java.io.IOException;

public class ArquivoContas
{
    File arquivo;
    private String caminho;

    public ArquivoContas()
    {
        File atual = new File(".");
        this.caminho = null;
        try {
            caminho = atual.getCanonicalPath(); //pegando caminho até o contexto atual
            //caminho apontado por atual: C:\Users\alcid\Desktop\projeto-2va-polido-refinado-magic
        } catch (IOException e) {
            e.printStackTrace(); //pritando erros de armazenamento
        }
    }

    public void setArquivoContas()
    {
        this.arquivo = new File(caminho + "\\src\\main\\java\\br\\ufrpe\\bcc\\ip2\\projeto\\arquivo\\arquivo1.txt");
        try {
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getArquivoContas()
    {
        setArquivoContas();
        return arquivo;
    }

    public String getCaminho()
    {
        return arquivo.getAbsolutePath();
    }

}
