package arquivo;

import beans.Boleto;
import beans.Conta;
import beans.Sistema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SalvarArquivo
{
    public void salvar(Sistema sistema, File arquivo)
    {
        FileWriter escritor = null;
        ArrayList<Conta> contas;
        ArrayList<Boleto> boletos;

        try
        {
            escritor = new FileWriter(arquivo);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        PrintWriter escrever = null;


        escrever = new PrintWriter(escritor);


        if(sistema.getContas()!= null)
        {

            contas = sistema.getContas();
            for(int i=0; i<contas.size(); i++)
            {
                escrever.println("<NOVA-CONTA>");
                Conta contaAux = new Conta();
                contaAux = contas.get(i);
                escrever.println(contaAux.getLogin());
                escrever.println(contaAux.getSenha());
                escrever.println(contaAux.getNome());
                escrever.println(contaAux.getCpf());
                escrever.println(contaAux.getDatadenascimento());
                escrever.println(contaAux.getDataDeCriacao());
                escrever.println(contaAux.isStatus());
                escrever.println(contaAux.getSaldo());

                boletos = contaAux.getBoletos();

                if(boletos!=null)
                {
                    for (int j=0;j<boletos.size();j++)
                    {
                        escrever.println("NOVO-BOLETO>");
                        Boleto boletoAux = new Boleto();
                        boletoAux = boletos.get(j);
                        escrever.println(boletoAux.getNomeDoBoleto());
                        escrever.println(boletoAux.getValor());
                        escrever.println(boletoAux.getDataDeCriacao());
                        escrever.println(boletoAux.getDataDeVencimento());
                        escrever.println(boletoAux.getValor());
                        escrever.println(boletoAux.isPagamento());
                        escrever.println("<FIM-BOLETO>");
                    }
                }
                escrever.println("<FIM-CONTA>");
            }
        }
        escrever.println("<FIM-ARQUIVO>");

        try
        {
            escritor.flush();
            escritor.close();
            escrever.flush();
            escrever.close();
        }
        catch (IOException x)
        {
            x.printStackTrace();
        }

    }
}

