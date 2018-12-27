package br.ufrpe.bcc.ip2.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public class Sistema
{
    private static List<Conta> contas = new ArrayList<>();

    public static List<Conta> getContas()
    {
      return contas;
    }

    public void addContas(Conta conta) {
        this.contas.add(conta);
    }

    public void removeContas(Conta conta)
    {
        this.contas.remove(conta);
        if(this.contas.contains(conta))
        {
            this.contas.remove(conta);
        }
        else
        {
            System.out.println("Irremovivel.");
        }
    }
}