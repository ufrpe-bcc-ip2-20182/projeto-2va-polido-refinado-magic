package arquivo;

import beans.Boleto;
import beans.Conta;
import beans.Sistema;
import util.DateandGenerateUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LerArquivo
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

        BufferedReader leitor = new BufferedReader(arquivoleitura);

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
                input = leitor.readLine();
                if(novaConta == null){
                    novaConta = new Conta();
                }
                if ("<NOVA-CONTA>".equals(input)) {
                    String aux = leitor.readLine();

                    novaConta.setLogin(aux);

                    aux = leitor.readLine();
                    novaConta.setSenha(aux);

                    novaConta.setNome(leitor.readLine());
                    novaConta.setCpf(leitor.readLine());

                    //data de nascimento
                    aux = leitor.readLine();
                    data = DateandGenerateUtils.converterData(aux);
                    novaConta.setDatadenascimento(data);

                    //data de criação
                    aux = leitor.readLine();
                    data = DateandGenerateUtils.converterData(aux);
                    novaConta.setDataDeCriacao(data);
                    /*try {
                        data = f.parse(leitor.readLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/

                    novaConta.setStatus(Boolean.getBoolean(leitor.readLine()));
                    novaConta.setSaldo(Double.parseDouble(leitor.readLine()));
                    novaConta.setEmail(leitor.readLine());

                } else if (input.equals("<NOVO-BOLETO>")) {
                    novoBoleto.setNomeDoBoleto(leitor.readLine());
                    novoBoleto.setValor(Double.parseDouble(leitor.readLine()));


                        //data = f.parse(leitor.readLine());
                        data = DateandGenerateUtils.converterData(leitor.readLine());


                    novoBoleto.setDataDeCriacao(data);

                    data = DateandGenerateUtils.converterData(leitor.readLine());

                    novoBoleto.setDataDeVencimento(data);
                    novoBoleto.setValor(Double.parseDouble(leitor.readLine()));
                    novoBoleto.setPagamento(Boolean.parseBoolean(leitor.readLine()));

                }

                else if (input.equals("<FIM-BOLETO>"))
                {
                    novaConta.setBoletos(novoBoleto);
                }
                else if (input.equals("<FIM-CONTA>"))
                {
                    sistema.addContas(novaConta);

                    if(novaConta.getBoletos() != null)
                    {
                        novaConta.limparBoletos();//o set de conta para boletos faz que todos os boletos inseridos sejam deletados
                    }
                    novaConta = null;
                }
                else
                {
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
