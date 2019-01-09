package util;


import beans.Boleto;
import beans.Conta;
import beans.Sistema;

import java.util.*;
import java.lang.String;

public abstract class ValidationUtils
{
    //essa classe tem a função de conferir problemas e resolver coisas em geral que podem dar errado

    public static boolean branco(String texto)
    {
        if(texto.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private static String[] cortarPalavras(String x)
    {
        String cortado[] = new String[x.length()];

        for(int i = 0; i < x.length(); i++)
        {
            cortado[i] = x.substring(i,i+1);
        }
        return cortado;
    }

    public static String[] cortarEspacos(String x)
    {
        String cortado[] = x.split(" ");
        return cortado;
    }

    public static boolean cpfcerto(String texto)
    {
        //ta printando errado
        String cortado[] = cortarPalavras(texto);
        for(int i = 0; i < texto.length(); i++)
        {
            if(!(i == 3 || i == 7 || i == 11))
            {
                if(!(cortado[i].charAt(0) >= 48 && cortado[i].charAt(0) <= 57))
                {
                    return false;
                }
            }
        }
        if(texto.charAt(3) == '.' && texto.charAt(7) == '.' && texto.charAt(11) == '-')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Conta existeConta(String nome, Sistema sis)
    {
        ArrayList<Conta> contas = sis.getContas();
        for (int i = 0; i < contas.size(); i++)
        {
            if(nome.equals(contas.get(i).getLogin()))
            {
                return contas.get(i);
            }
        }
        return null;
    }

    public static Boleto existeBoleto(String nome, Conta con)
    {
        ArrayList<Boleto> boletos = con.getBoletos();
        for(int i = 0; i < boletos.size(); i++)
        {
            if(nome.equals(boletos.get(i).getNomeDoBoleto()))
            {
                return boletos.get(i);
            }
        }
        return null;
    }

    public static double pegarDouble()
    {
        boolean controller = true;
        Scanner scan = new Scanner(System.in);
        double num = 0;
        while(true)
        {
            controller = true;
            try
            {
                num = scan.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Você digitou algo errado!");
                controller = false;
                scan.next();
                System.out.println("Tente de novo!");
            }
            finally
            {
                if(controller == true)
                {
                    System.out.println("Tudo certo!");
                    break;
                }
            }
        }
        return num;
    }

    public static boolean comparaDatas(Date dataInicial, Date dataFinal)
    {
        if(dataFinal.after(dataInicial))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
