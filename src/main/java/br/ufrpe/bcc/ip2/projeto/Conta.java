package br.ufrpe.bcc.ip2.projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Conta extends Pessoa
{
    private String login;
    private String senha;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public Date getDataDeCriacao()
    {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao)
    {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public Conta()
    {
        this.setNome("Nome");
        this.setCpf("000.000.000-78");
        SimpleDateFormat h = new SimpleDateFormat("dd/MM/yyyy");
        Date aux = null;
        try
        {
            aux = h.parse("00/00/0000");
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        this.setDatadenascimento(aux);
    }

    @Override
    public void cadastro()
    {
        System.out.print("Digite seu nome: ");
        Scanner scanner = new Scanner(System.in);
        this.setNome(scanner.nextLine());
        System.out.print("Digite seu cpf: ");
        this.setCpf(scanner.nextLine());
        System.out.print("Digite sua Data de Nascimento (formato 'dd/mm/aaaa'): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = Verif.pegarData();
        this.setDatadenascimento(data);
    }

    public boolean login()
    {
        return true;
    }

    private Date dataDeCriacao;
    private double saldo;
    private boolean status;
    private ArrayList<Boleto> boletos;

    public boolean pagarBoleto(Boleto bol)
    {
        //vai ter um monte de condição pra ver se isso vai dar certo. Se der tudo certo, retorna true. Lá onde isso for
        //chamado vammos ter uma verificação se deu tudo certo. Se não der, aborta tudo e relata o erro!
        return true;
    }

    public boolean adicionarBoleto(Boleto bol)
    {
        boletos.add(bol);
        //vai ter um monte de condição pra ver se isso vai dar certo. Se der tudo certo, retorna true. Lá onde isso for
        //chamado vammos ter uma verificação se deu tudo certo. Se não der, aborta tudo e relata o erro!
        return true;
    }

    public void mostrarPendencias()
    {
        for(Boleto aux: boletos)
        {
            int i = 1;
            System.out.println("Pendencia: " + i + ": " + aux.getNomeDoBoleto());
            System.out.println("Data de vencimento do boleto: " + aux.getDataDeVencimento());
        }
    }
}
