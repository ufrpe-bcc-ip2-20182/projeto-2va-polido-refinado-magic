package beans;

import util.Getters;
import util.Verif;
import arquivo.SalvarArquivo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Adicionar
{

    public void adicionarConta(Sistema sis)
    {
        sis.addContas(cadastrar());
        //SalvarArquivo salvarArquivo = new SalvarArquivo();
        //salvarArquivo.salvar(sis, new File("arquivo.txt")); por hora, não vamos usar
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nova.setNome(scanner.nextLine());
        System.out.print("Digite seu cpf: ");
        nova.setCpf(scanner.nextLine());
        System.out.println("Nome: " + nova.getNome() +"\nCPF: " + nova.getCpf());
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
        Date data = Getters.pegarData();
        nova.setDatadenascimento(data);
        System.out.println("Digite um login: ");
        //verificação se o login já existe
        nova.setLogin(scanner.nextLine());
        System.out.println("Digite sua senha ");
        String senha = scanner.nextLine();
        System.out.println("Redigite sua senha ");
        String senha2 = scanner.nextLine();
        while (!(senha.equals(senha2)))
        {
            System.out.println("\nSuas senhas não batem! Digite novamente.");
            System.out.println("Digite sua senha ");
            senha = scanner.nextLine();
            System.out.println("Redigite sua senha ");
            senha2 = scanner.nextLine();
            System.out.println("Senha 1: " + senha);
            System.out.println("Senha 2: " + senha2);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataaux = null;
        try
        {
            dataaux = dateFormat.parse(Getters.getDiadeHoje());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        nova.setDataDeCriacao(dataaux);
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
