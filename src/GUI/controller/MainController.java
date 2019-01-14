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

    private Sistema sistema = new Sistema();
    private Arquivo arquivo = new Arquivo();
    private LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas;
    private ArrayList<String> logins = new ArrayList<>();
    private ArrayList<String> senhas = new ArrayList<>();

    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        contas = sistema.getContas();

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
        boolean loginOk = false;
        String login;
        String senha;
        int indice = -1;

        sistema = lerArquivo.ler(arquivo.getArquivo());
        contas = sistema.getContas();

        try{
            for (int i = 0; i < contas.size(); i++){
                logins.add(contas.get(i).getLogin());
                senhas.add(contas.get(i).getSenha());
            }
            login = userField.getText();
            if(logins.contains(login))
            {
                indice = logins.indexOf(login);
                senha = passwordField.getText();

                if(senhas.indexOf(senha)==indice){
                    stage = (Stage) loginButton.getScene().getWindow();
                    root = (Parent) FXMLLoader.load(getClass().getResource("/GUI/view/Logado.fxml"));
                    loginOk = true;
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Falha de Login");
                    alert.setHeaderText("Informações inválidas");
                    alert.setContentText("Senha incorreta");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Falha de Login");
                alert.setHeaderText("Informações inválidas");
                alert.setContentText("Usuário não encontrado");
                alert.showAndWait();
            }
            if(loginOk){
                ArquivoContas arquivoContas = new ArquivoContas();
                SalvarConta.salvar(arquivoContas.getArquivo(),indice);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                String tituloAtual = stage.getTitle();
                stage.setTitle(tituloAtual +" - "+ (""+user.charAt(0)).toUpperCase() + user.substring(1, user.length()));
                stage.setResizable(true);
                sis.changeStage(stage);
            }
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


