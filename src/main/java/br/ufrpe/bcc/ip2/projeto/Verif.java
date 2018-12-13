package br.ufrpe.bcc.ip2.projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private static String[] cortarPalavras(String x)
    {
        String cortado[] = new String[x.length()];

        for(int i = 0; i < x.length(); i++)
        {
            cortado[i] = x.substring(i,i+1);
        }
        return cortado;
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


    /*public static boolean verificarcpf(String texto)
    {
        if(texto.length()!=14)
        {
          return false;
        }

        String cortado[] = cortarPalavras(texto);
        for(int i = 0; i < texto.length(); i++)
        {
                if(i == 3 || i == 7)
                {
                    if(!(cortado[i] == "."))
                    {
                        return false;
                    }
                }
                else if(i == 11)
                {
                    if(!(cortado[i] == "-"))
                    {
                        return false;
                    }
                }
                else
                {
                    if(!(48 <= Double.parseDouble(cortado[i]) && Double.parseDouble(cortado[i]) <= 57))
                    {
                        return false;
                    }
                }
             }
             return true;
      }*/

    public  static boolean cpfcerto2(String texto)
    {
        if(texto.length()!=14)
        {
            return false;
        }

        String caracteres[] = cortarPalavras(texto);

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
            if(aux==0)
            {
                return false;
            }
        }

        if( (caracteres[3].equals(".")) && (caracteres[7].equals(".")) && (caracteres[11].equals("-")) )
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

    public static Date pegarData()
    {
        boolean controller = true;
        Scanner scan = new Scanner(System.in);
        String auxData;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        while(true)
        {
            controller = true;
            try
            {
                data = dateFormat.parse(scan.nextLine());
            }
            catch (ParseException x)
            {
                System.out.println("Erro de formatação!");
                controller = false;
            }
            finally
            {
                if(controller)
                {
                    break;
                }
            }
        }
        return data;
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
