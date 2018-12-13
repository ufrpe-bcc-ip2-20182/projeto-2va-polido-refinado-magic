package br.ufrpe.bcc.ip2.projeto;

import java.io.File;
import java.io.*;

public class Arquivos
{
    File h = new File("");
    private static String caminho;

    public static void criarDiretorio()
    {
        File x = new File("Backups");
        File file = new File("C:\\Users\\alcides.cunha\\IdeaProjects\\projeto-2va-polido-refinado-magic\\Backups\\testes.txt");
        boolean success = x.mkdir();
        caminho = x.getAbsolutePath();
        if (!success)
        {
            // Falha no momento de criar o diretório
        }
        try
        {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void Salvar(Conta c)
    {
        //contas 0
        //pessoas 0
        //boletos 0
    }
}
