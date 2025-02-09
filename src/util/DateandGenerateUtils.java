package util;

import beans.Conta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateandGenerateUtils
{
    public static String getDiadeHoje()
    {
        Calendar c = Calendar.getInstance();
        String dataDeHoje = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(c.get(Calendar.MONTH)+1) + "/" + String.valueOf(c.get(Calendar.YEAR));
        return dataDeHoje;
    }

    public static String converteData(Date data) throws ParseException
    {
        Date hoje = data;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(hoje);
    }

    public static void gerarId(Conta conta)
    {
        String aux = conta.getNome();
        String nova = aux.substring(aux.length()-2,aux.length()); //pega 2 ultimos caracteres
        Date x = conta.getDatadenascimento();
        String aux2 = x.toString();
        aux2 = aux2.substring(3,5); //pega o mes
        aux = nova + aux2; //junta tudo e gera o id
        conta.setId(aux);
    }

    public static Date converterData(String data)
    {
        String[] partes = ValidationUtils.cortarEspacos(data);
        int h = 0;
        switch (partes[1])
        {
            case "Jan":
                h = 1;
                break;

            case "Fev":
                h = 2;

                break;

            case "Mar":
                h = 3;
                break;

            case "Apr":
                h = 4;
                break;

            case "May":
                h = 5;
                break;

            case "Jun":
                h = 6;
                break;

            case "Jul":
                h = 7;
                break;

            case "Aug":
                h = 8;
                break;

            case "Sep":
                h = 9;
                break;

            case "Oct":
                h = 10;
                break;

            case "Nov":
                h = 11;
                break;

            case "Dec":
                h = 12;
                break;

            default:
                break;

        }
        if(h < 10)
        {
            data = partes[2] + "/" + "0" + h + "/" + partes[5];
        }
        else
        {
            data = partes[2] + "/" + h + "/" + partes[5];
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataretornada = null;
        try
        {
            dataretornada = dateFormat.parse(data);
        }
        catch (ParseException x)
        {
            System.out.println(x);
        }

        return dataretornada;
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
}
