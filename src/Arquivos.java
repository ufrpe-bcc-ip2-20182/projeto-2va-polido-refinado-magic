

import beans.Conta;

import java.io.File;
import java.io.*;

public class Arquivos
{
    File h = new File("");
    private static String caminho;

    public static void criarDiretorio()
    {
        File x = new File("Backups");
        File caminho = new File(".");
        try {
            System.out.println(caminho.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(caminho + "\\Backups\\" + "testes.txt");
        boolean success = x.mkdir();
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

    }
}
