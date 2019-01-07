import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Adicionar;
import beans.Conta;
import beans.Sistema;
import controller.Login;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Executando...");

        //para poder fazer o login, precisamos verificar algum tipo de array de contas
        Arquivo arquivo = new Arquivo();
        Sistema sistema = LerArquivo.ler(arquivo.getArquivo());
       /* ArrayList<Conta> contas = Sistema.getContas();
        int i = 0;
        Conta c = (Conta) contas.get(i);
        System.out.println("Login: " + c.getLogin() + "\nSenha: " + c.getSenha());
        /*SalvarArquivo salvar = new SalvarArquivo();
        Adicionar add = new Adicionar();
        add.adicionarConta(sistema);
        salvar.salvar(sistema, arquivo.getArquivo());*/
       // Login.login(sistema);
    }
}
