package br.ufrpe.bcc.ip2.projeto.controller;

import java.io.File;
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
        File arquivo = new File("C:\\Users\\Josenita Vidal\\IdeaProjects\\projeto-2va-polido-refinado-magic\\src\\main\\java\\br\\ufrpe\\bcc\\ip2\\projeto\\arquivo\\Conta.txt");

        this.arquivoContas = arquivo;
    }
}
