package br.ufrpe.bcc.ip2.projeto.beans;

import br.ufrpe.bcc.ip2.projeto.arquivo.SalvarArquivo;
import br.ufrpe.bcc.ip2.projeto.controller.ArquivoContas;
import br.ufrpe.bcc.ip2.projeto.util.Verif;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Adicionar
{

    public void adicionarConta(Conta x)
    {
        Sistema s = new Sistema();
        s.addContas(x);
        ArquivoContas caminho = new ArquivoContas();
        System.out.println(caminho.getArquivoContas());
        SalvarArquivo.salvar(caminho.getArquivoContas(),x);
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
        Date data = Verif.pegarData();
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
