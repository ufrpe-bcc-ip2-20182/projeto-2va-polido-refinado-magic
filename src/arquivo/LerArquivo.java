package arquivo;

import beans.Boleto;
import beans.Conta;
import beans.Sistema;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class LerArquivo
{
    public static Sistema ler(File arquivo)
    {
        FileReader arquivoleitura = null;

        try {
          arquivoleitura = new FileReader(arquivo);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }

        BufferedReader ler = new BufferedReader(arquivoleitura);

        Sistema sistema = new Sistema();
        Conta novaConta = new Conta();
        Boleto novoBoleto = new Boleto();
        Date data = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String input;

        while(true)
        {
            try
            {

                input = ler.readLine();
                if (input == "<NOVA-CONTA>") {
                    novaConta.setLogin(ler.readLine());
                    novaConta.setSenha(ler.readLine());
                    novaConta.setNome(ler.readLine());
                    novaConta.setCpf(ler.readLine());

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
                } else if (input == "<NOVO-BOLETO>") {
                    novoBoleto.setNomeDoBoleto(ler.readLine());
                    novoBoleto.setValor(Double.parseDouble(ler.readLine()));

                    try {
                        data = f.parse(ler.readLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    novoBoleto.setDataDeCriacao(data);

                    try {
                        data = f.parse(ler.readLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    novoBoleto.setDataDeVencimento(data);
                    novoBoleto.setValor(Double.parseDouble(ler.readLine()));
                    novoBoleto.setPagamento(Boolean.parseBoolean(ler.readLine()));
                } else if (input == "<FIM-BOLETO>") {
                    novaConta.setBoletos(novoBoleto);
                } else if (input == "<FIM-CONTA>") {
                    sistema.addContas(novaConta);
                    novaConta.setBoletos(); //o set de conta para boletos faz que todos os boletos inseridos sejam deletados
                } else {
                    break;
                }

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        try {
            arquivoleitura.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return sistema;
    }

}
