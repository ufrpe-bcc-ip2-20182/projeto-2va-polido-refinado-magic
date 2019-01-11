package GUI.controller;

import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Conta;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

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



    @FXML TextField userField;
    @FXML PasswordField passAntiga;
    @FXML PasswordField passField;
    @FXML PasswordField pass2Field;
    @FXML Button addButton;


    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        contas = sistema.getContas();

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

        String usuario;
        boolean aux = false;
        usuario = userField.getText();
        int aux2 = 0;

        for(int i = 0; i < contas.size(); i++) {
            senhas.add(contas.get(i).getSenha());
            logins.add(contas.get(i).getLogin());
        }
        for(int i = 0; i < logins.size(); i++) {
            if(logins.get(i).equals(usuario) == true){
                aux = true;
                aux2 = i;
            }
        }
        if (aux == true) {
            System.out.println(usuario);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Usuário não encontrado");
            alert.showAndWait();
        }

        String senhaUser;
        senhaUser = passAntiga.getText();
        if(senhaUser.equals(senhas.get(aux2)) == true){
            System.out.println(senhaUser);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Senha incorreta");
            alert.showAndWait();
        }

        String senha, senha2;
        senha = passField.getText();
        senha2 = pass2Field.getText();
        if(senha.equals(senha2) == true){
            System.out.println(senha);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Senhas não correspondem");
            alert.showAndWait();
        }

    }
    public void setUsuario(int indice){
        this.usuario = indice;
    }

    @FXML
    protected void btSair(ActionEvent e){ MainJavaFX.changeScreen("logado");
    }
}
