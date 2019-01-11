import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Sistema;
import util.ValidationUtils;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Executando...");
        System.out.println(ValidationUtils.cpfcerto("000.000.000-00"));
        Arquivo arquivo = new Arquivo();
        Sistema sistema = LerArquivo.ler(arquivo.getArquivo());
    }
}
