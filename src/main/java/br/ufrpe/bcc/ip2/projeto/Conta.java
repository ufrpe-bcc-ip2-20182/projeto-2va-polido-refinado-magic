package br.ufrpe.bcc.ip2.projeto;

import java.util.ArrayList;
import java.util.Date;

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

    private Date dataDeCriacao;
    private double saldo;
    private boolean status;
    //private ArrayList<Boletos> boletos;

    public Conta()
    {

    }
}
