package br.ufrpe.bcc.ip2.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public class Sistema
{
    private static List<Conta> contas = new ArrayList<>();

    public static List<Conta> getConta()
    {
      return contas;
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }
}