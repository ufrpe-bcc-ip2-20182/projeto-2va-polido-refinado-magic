package GUI.controller;
import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.*;
import controller.ArquivoContas;
import controller.SalvarConta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class MainController {

    private MainJavaFX sis;

    @FXML private PasswordField passwordField;
    @FXML private TextField userField;
    @FXML private Button loginButton;

    private String user;

    private Sistema sistema;
    private Arquivo arquivo;
    private LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas;
//    private ArrayList<String> logins = new ArrayList<>();
//    private ArrayList<String> senhas = new ArrayList<>();
    private boolean logado;

    public void initialize(){
        this.sistema = new Sistema();
        this.arquivo = new Arquivo();
        logado = false;


        //sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        //contas = sistema.getContas();

        this.passwordField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                login();
            }
        });
        this.loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                login();
            }
        });
    }

    private void login(){

        Stage stage = null;
        Parent root = null;
        //boolean loginOk = false;
        int indice = -1;

        sistema = LerArquivo.ler(arquivo.getArquivo());
        contas = sistema.getContas();
        String login = userField.getText();
        String senha = passwordField.getText();

        try{
//            for (int i = 0; i < contas.size(); i++){
//                logins.add(contas.get(i).getLogin());
//                senhas.add(contas.get(i).getSenha());
//                System.out.println(logins.get(i)+" "+senhas.get(i));
//            }
            for(Conta c: this.contas){
                if(c.getLogin().equals(login) && c.getSenha().equals(senha)){
                    logado = true;
                }
            }

            for(int i=0;i<contas.size();i++)
            {
                if(contas.get(i).getLogin().equals(login) && contas.get(i).getSenha().equals(senha)){
                    indice = i;
                }
            }

            if(logado)
            {
                stage = (Stage) loginButton.getScene().getWindow();
                root = (Parent) FXMLLoader.load(getClass().getResource("/GUI/view/Logado.fxml"));
                //loginOk = true;
                MainJavaFX.changeScreen("logado");
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Falha de Login");
                alert.setHeaderText("Informações inválidas");
                alert.setContentText("Usuário não encontrado");
                alert.showAndWait();
            }
            ArquivoContas arquivoContas = new ArquivoContas();
            SalvarConta.salvar(arquivoContas.getArquivo(),indice);
//            if(loginOk){
//
//
//                userField.clear();
//                passwordField.clear();
//
//                MainJavaFX.changeScreen("logado");
//            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setApp(MainJavaFX sis){
        this.sis = sis;
    }

    @FXML
    protected void btCadastro(ActionEvent e){
        MainJavaFX.changeScreen("cadastro");
    }

}


