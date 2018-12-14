package br.ufrpe.bcc.ip2.projeto.controller;

import br.ufrpe.bcc.ip2.projeto.Conta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public abstract class LerConta
{
    public static void ler(Conta conta, Path caminho) throws IOException
    {
        File arquivoContas = new File(caminho.toString());
        FileReader arquivo = new FileReader(arquivoContas);
        BufferedReader ler = new BufferedReader(arquivo);

        conta.setLogin(ler.readLine());
        conta.setSenha(ler.readLine());

        arquivo.close();
    }

}
