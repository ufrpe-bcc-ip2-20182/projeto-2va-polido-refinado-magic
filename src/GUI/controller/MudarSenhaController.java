package GUI.controller;

import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Boleto;
import beans.Conta;
import beans.Sistema;
import controller.ArquivoContas;
import controller.LerConta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.ArrayList;

public class MudarSenhaController {

    private Sistema sistema = new Sistema();
    private Arquivo arquivo = new Arquivo();
    private LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<String> logins = new ArrayList<>();
    private ArrayList<String> senhas = new ArrayList<>();
    private MainJavaFX sis;
    private int usuario;

    @FXML PasswordField passAntiga;
    @FXML PasswordField passField;
    @FXML PasswordField pass2Field;
    @FXML Button addButton;

    public void initialize(){
        this.sis = MainJavaFX.getInstance();

        this.passField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                mudarSenha();
            }
        });
        this.addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mudarSenha();
            }
        });
    }

    public void mudarSenha(){

        boolean senhaOk = false;
        int indice = -1;

        ArquivoContas arquivoContas = new ArquivoContas();
        sistema = LerArquivo.ler(arquivo.getArquivo());
        ArrayList<Conta> contas = sistema.getContas();


        try
        {
            indice = LerConta.ler(arquivoContas.getArquivo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<Boleto> boletos = sistema.getContas().get(indice).getBoletos();
        Conta conta = contas.get(indice);

        String senha, senha2, senhaAntes;
        senhaAntes = passAntiga.getText();
        senha = passField.getText();
        senha2 = pass2Field.getText();
        if( (senhaAntes.equals(conta.getSenha())) && (senha.equals(senha2) && (!senha.equals(conta.getSenha())) ) ){

            if( (!senha.equals("<NOVA-CONTA>")) && (!senha.equals("<NOVO-BOLETO>")) && (!senha.equals("<FIM-BOLETO>")) && (!senha.equals("<FIM-CONTA>")) && (!senha.equals("<FIM-ARQUIVO>")) )
            {
               senhaOk = true;
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Informações inválidas");
                alert.setContentText("Senha inválida");
                alert.showAndWait();
            }
        }else{
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("ERRO");
            alert2.setHeaderText("Informações inválidas");
            alert2.setContentText("Senhas não correspondem");
            alert2.showAndWait();
        }

        if(senhaOk)
        {
            sistema.getContas().get(indice).setSenha(senha);
            for(int i=0;i<boletos.size();i++)
            {
                sistema.getContas().get(indice).setBoletos(boletos.get(i));
            }
            SalvarArquivo salvarArquivo = new SalvarArquivo();
            salvarArquivo.salvar(sistema, arquivo.getArquivo());
            passAntiga.clear();
            passField.clear();
            pass2Field.clear();
            Alert alert4 = new Alert(Alert.AlertType.INFORMATION);
            alert4.setTitle("Confirmação.");
            alert4.setHeaderText("Senha alterada com sucesso");
            alert4.showAndWait();
        }
    }

    @FXML
    protected void btSair(ActionEvent e){ MainJavaFX.changeScreen("logado");
    }
}
