package br.ufrpe.bcc.ip2.projeto;

import java.util.*;
import java.lang.String;
import java.lang.Object.*;

public abstract class Verif
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

    public static boolean cpfcerto(String texto)
    {
        //ta printando errado
        String cortado[] = new String[texto.length()];
        for(int i = 0; i < texto.length(); i++)
        {
            cortado[i] = texto.substring(i,i+1);
            System.out.println("Posição " + i + ": " + cortado[i]);
        }
        if((cortado[3] == ".") && (cortado[7] == ".") && (cortado[11] == "-"))
        {
            return true;
        }
        else
        {
            return false;
        }
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
}
