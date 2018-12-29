package br.ufrpe.bcc.ip2.projeto.beans;

import br.ufrpe.bcc.ip2.projeto.util.Getters;
import br.ufrpe.bcc.ip2.projeto.util.Verif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Adicionar
{

    public void adicionarConta(Sistema sis)
    {
        sis.addContas(cadastrar());
    }

    public void adicionarBoleto(Conta con)
    {
        con.setBoletos();
    }

    public Boleto inserirBoleto()
    {
        Boleto bol = new Boleto();
        System.out.print("Digite o nome do boleto: ");
        Scanner scanner = new Scanner(System.in);
        bol.setNomeDoBoleto(scanner.nextLine());
        System.out.print("Digite o valor do boleto: ");
        bol.setValor(scanner.nextDouble());
        System.out.print("Digite a Data de Criação (formato 'dd/mm/aaaa'): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try
        {
            data = dateFormat.parse(Getters.getDiadeHoje());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        bol.setDataDeCriacao(data);
        System.out.print("Digite a Data de Vencimento (formato 'dd/mm/aaaa'): ");
        data = Getters.pegarData();
        bol.setDataDeVencimento(data);
        return bol;
    }

    public void removerBoleto(String nomedoboleto, Conta conta)
    {
        Boleto aux = Verif.existeBoleto(nomedoboleto, conta);
        if (aux != null)
        {
            conta.removeBoleto(aux);
        }
    }
    public Conta cadastrar()
    {
        Conta nova = new Conta();
        System.out.print("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        nova.setNome(scanner.nextLine());
        System.out.print("Digite seu cpf: ");
        nova.setCpf(scanner.nextLine());
        /*boolean fluxo = true;
        do
        {
            fluxo = nova.setCpf(scanner.nextLine());
            if(!fluxo)
            {
                System.out.println("Você digitou um cpf inválido!");
            }
        }
        while (!fluxo);*/
        System.out.print("Digite sua Data de Nascimento (formato 'dd/mm/aaaa'): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = Getters.pegarData();
        nova.setDatadenascimento(data);
        return nova;
    }
    public void gerarId(Conta conta)
    {
        String aux = conta.getNome();
        String nova = aux.substring(aux.length(),aux.length()-2); //pega 2 ultimos caracteres
        Date x = conta.getDatadenascimento();
        String aux2 = x.toString();
        aux2 = aux2.substring(3,5); //pega o mes
        aux = nova + aux2; //junta tudo e gera o id
        conta.setId(aux);
    }
}
