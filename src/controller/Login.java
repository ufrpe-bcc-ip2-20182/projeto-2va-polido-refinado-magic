package controller;

import util.Verif;
import beans.Conta;
import beans.Sistema;

import java.util.Scanner;

public class Login
{
    public static void login(Sistema sistema)
    {
        System.out.print("Bem vindo ao sistema de login! \nDigite seu login:");
        Conta contaatual = new Conta();
        Scanner scan = new Scanner(System.in);
        String login = scan.nextLine();
        System.out.print("Digite sua senha:");
        String senha = scan.nextLine();
        contaatual = Verif.existeConta(login,sistema);
        if(contaatual != null)
        {
            if(senha.equals(contaatual.getSenha()))
            {
                System.out.println("Bem vindo " + contaatual.getNome() + "!");
            }
        }
        else
        {
            System.out.println("Conta não localizada!");
        }
    }
}
