package br.ufrpe.bcc.ip2.projeto;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Executando...");
        Conta conta = new Conta();
        //conta.cadastro();
        boolean x = Verif.cpfcerto("123.456.789-10");
        boolean controller = true;
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            controller = true;
            try
            {
                double num = scan.nextDouble();
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
        //System.out.println(x);
        //para poder fazer o login, precisamos verificar algum tipo de array de contas
        //a mesma coisa para o cadastro, tem que ter algum tipo de array de contas
    }
}
