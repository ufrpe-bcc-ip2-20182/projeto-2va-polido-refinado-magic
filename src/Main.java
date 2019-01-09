import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Sistema;
import util.ValidationUtils;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Executando...");
        System.out.println(ValidationUtils.cpfcerto("000.000.000-00"));
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
