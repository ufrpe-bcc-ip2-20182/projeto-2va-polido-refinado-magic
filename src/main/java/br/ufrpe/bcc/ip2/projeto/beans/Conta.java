package br.ufrpe.bcc.ip2.projeto.beans;

import br.ufrpe.bcc.ip2.projeto.util.Verif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Conta extends Pessoa
{
    private String login;
    private String senha;
    private String id;

    public String getId() {
        return id;
    }

    public void gerarId()
    {
        String aux = this.getNome();
        String nova = aux.substring(aux.length(),aux.length()-2); //pega 2 ultimos caracteres
        Date x = this.getDatadenascimento();
        String aux2 = x.toString();
        aux2 = aux2.substring(3,5); //pega o mes
        aux = nova + aux2; //junta tudo e gera o id
        this.id = aux;
    }

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
        this.setCpf("000.000.000-00");
        SimpleDateFormat h = new SimpleDateFormat("dd/MM/yyyy");
        Date aux = null;
        try
        {
            aux = h.parse("01/01/0000");
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        this.setDatadenascimento(aux);
    }


    private Date dataDeCriacao;
    private double saldo;
    private boolean status;
    private ArrayList<Boleto> boletos;

}
