package br.ufrpe.bcc.ip2.projeto.arquivo;

import br.ufrpe.bcc.ip2.projeto.beans.Boleto;
import br.ufrpe.bcc.ip2.projeto.beans.Conta;
import br.ufrpe.bcc.ip2.projeto.beans.Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                novaConta.setNome(ler.readLine());
                novaConta.setCpf(ler.readLine());

                Date data = new Date();
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    data = f.parse(ler.readLine());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                novaConta.setDatadenascimento(data);

                try {
                    data = f.parse(ler.readLine());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                novaConta.setDataDeCriacao(data);
                novaConta.setStatus(Boolean.getBoolean(ler.readLine()));
                novaConta.setSaldo(Double.parseDouble(ler.readLine()));
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
                sistema.addContas(novaConta);
                novaConta.setBoletos(); //o set de conta para boletos faz que todos os boletos inseridos sejam deletados
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
