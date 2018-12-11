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

    public  static boolean cpfcerto2(String texto)
    {
        String caracteres[] = new String[texto.length()];

        for(int i=0;i<texto.length();i++)
        {
            caracteres[i] = texto.substring(i,i+1);
        }


        for(int i=0;i<texto.length();i++)
        {
            int aux=0;
            for(int j=0;j<=9;j++)
            {
                if( caracteres[i].equals(String.valueOf(j)))
                {
                    aux++;
                }
            }
            if(aux==0) return false;
        }

        if( (caracteres[3].equals(".")) && (caracteres[7].equals(".")) && (caracteres[11].equals("-")) )
        {
            return true;
        }
        else {
            return false;
        }

    }
}
