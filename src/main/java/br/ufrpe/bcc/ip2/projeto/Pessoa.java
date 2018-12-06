package br.ufrpe.bcc.ip2.projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Pessoa
{
    private String nome;
    private Date datadenascimento;
    private String cpf;
    private Conta conta;

    public Date getDatadenascimento()
    {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento)
    {
        this.datadenascimento = datadenascimento;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public Conta getConta()
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Conta Cadastro(){
        Conta conta = new Conta();
        System.out.print("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        conta.setNome(scanner.nextLine());
        System.out.print("Digite seu cpf: ");
        conta.setCpf(scanner.nextLine());
        System.out.print("Digite sua Data de Nascimento (formato 'dd/mm/aaaa'): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try
        {
            data = dateFormat.parse(scanner.nextLine());
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        conta.setDatadenascimento(data);
        System.out.println(data);
        System.out.println("Data normal: " + dateFormat.format(data));
        return conta;
    }
    public Pessoa()
    {

    }
}
