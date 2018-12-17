package br.ufrpe.bcc.ip2.projeto.arquivo;

import br.ufrpe.bcc.ip2.projeto.beans.Boleto;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;
import br.ufrpe.bcc.ip2.projeto.beans.Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class LerArquivo
{
    public static Sistema ler(File arquivo) throws IOException
    {
        FileReader arquivoleitura = new FileReader(arquivo);
        BufferedReader ler = new BufferedReader(arquivoleitura);

        Sistema sistema = new Sistema();
        Conta novaConta = new Conta();
        Boleto novoBoleto = new Boleto();

        String input;

        while(true)
        {
            input = ler.readLine();
            if(input=="<NOVA-CONTA>")
            {
                novaConta.setLogin(ler.readLine());
                novaConta.setSenha(ler.readLine());
            }
            else if(input=="<NOVO-BOLETO>")
            {
                novoBoleto.setNomeDoBoleto(ler.readLine());
                novoBoleto.setValor(Double.parseDouble(ler.readLine()));
            }
            else if(input=="<FIM-BOLETO>")
            {
                novaConta.setBoletos(novoBoleto);
            }
            else if(input=="<FIM-CONTA>")
            {
                sistema.setContas(novaConta);
                novaConta.setBoletos();
            }
            else
            {
                break;
            }
        }
        arquivoleitura.close();
        return sistema;
    }

}
