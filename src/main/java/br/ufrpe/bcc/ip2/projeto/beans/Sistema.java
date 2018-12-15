package br.ufrpe.bcc.ip2.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class Sistema
{
    private List<Conta> conta = new ArrayList<>();

    public List<Conta> getConta()
    {
      return this.conta;
    }
}