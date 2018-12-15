package br.ufrpe.bcc.ip2.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class Sistema
{
    private static List<Conta> conta = new ArrayList<>();

    public static List<Conta> getConta()
    {
      return conta;
    }

    public static void setConta(List<Conta> contarec) {
        conta = contarec;
    }
}