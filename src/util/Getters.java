package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Getters
{
    public static String getDiadeHoje()
    {
        Calendar c = Calendar.getInstance();
        String dataDeHoje = String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(c.get(Calendar.MONTH)+1) + "/" + String.valueOf(c.get(Calendar.YEAR));
        return dataDeHoje;
    }

    public static Date converterData(String data)
    {
        String[] partes = Verif.cortarEspacos(data);
        data = partes[1] + "/" + partes[2] + "/" + partes[5];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataretornada = null;

        try
        {
            dataretornada = dateFormat.parse(data);
        }
        catch (ParseException x)
        {
            //Ignora amore :)
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
