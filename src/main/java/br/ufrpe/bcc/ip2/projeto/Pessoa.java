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

    public void Cadastro()
    {

    }
    public Pessoa()
    {

    }
}
