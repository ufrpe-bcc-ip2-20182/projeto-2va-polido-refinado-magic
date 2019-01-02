import arquivo.Arquivo;
import arquivo.SalvarArquivo;
import beans.Adicionar;
import beans.Sistema;
import controller.Login;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Executando...");

        //para poder fazer o login, precisamos verificar algum tipo de array de contas

        Arquivo arquivo = new Arquivo();
        Sistema sistema = new Sistema();
        SalvarArquivo salvar = new SalvarArquivo();
        Adicionar add = new Adicionar();
        add.adicionarConta(sistema);
        salvar.salvar(sistema, arquivo.getArquivo());
        Login.login(sistema);
    }
}
