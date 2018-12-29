package br.ufrpe.bcc.ip2.projeto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Getters
{
    public static String getDiadeHoje()
    {
        Calendar c = Calendar.getInstance();
        String dataDeHoje = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(c.get(Calendar.MONTH)+1) + "/" + String.valueOf(c.get(Calendar.YEAR));
        System.out.println(dataDeHoje);
        return dataDeHoje;
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
