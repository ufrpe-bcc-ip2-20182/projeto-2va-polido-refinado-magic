package UI.controller;

import UI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Conta;
import beans.Sistema;
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
import util.Getters;
import util.Verif;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CadastroController {

    @FXML private PasswordField passField;
    @FXML private PasswordField passOkField;
    @FXML private TextField nomeField;
    @FXML private TextField dataDeNascField;
    @FXML private TextField CPFField;
    @FXML private Button cadastrarButton;
    @FXML private TextField emailField;
    @FXML private TextField userField;
    @FXML private TextField saldoField;

    private MainJavaFX sis;

    private Sistema sistema = new Sistema();
    private Arquivo arquivo = new Arquivo();
    private LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<String> logins = new ArrayList<>();

    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        contas = sistema.getContas();

        this.passField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastro();
            }
        });
        this.cadastrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastro();
            }
        });
    }

    private void cadastro()
    {
        Stage stage = null;
        Parent root = null;
        boolean cadastroOk = false;

        String nome;
        nome = nomeField.getText();
        System.out.println(nome);

        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = null;
        java.util.Date data2 = null;


        try {
            data2 = f.parse(dataDeNascField.getText());
            data = f.parse(Getters.getDiadeHoje());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (data.after(data2) == true) {
            System.out.println(data2);
            System.out.println(data);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Cadastro");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Data inválida");
            alert.showAndWait();
        }


        String cpf;
        cpf = CPFField.getText();
        if(true){
            System.out.println(cpf);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Cadastro");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("CPF inválido");
            alert.showAndWait();
        }

        String email;
        email = emailField.getText();
        System.out.println(email);

        String usuario;
        boolean aux = false;
        usuario = userField.getText();

        for(int i = 0; i < contas.size(); i++) {
            logins.add(contas.get(i).getLogin());
        }
        for(int i = 0; i < logins.size(); i++) {
            if(logins.get(i).equals(usuario) == true){
                aux = true;
            }
        }
        if (aux == false) {
            System.out.println(usuario);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Cadastro");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Usuário inválido");
            alert.showAndWait();
        }

        String senha, senha2;
        senha = passField.getText();
        senha2 = passOkField.getText();
        if(senha.equals(senha2) == true){
            System.out.println(senha);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Cadastro");
            alert.setHeaderText("Informações inválidas");
            alert.setContentText("Senhas não correspondem");
            alert.showAndWait();
        }

        String saldo;
        Double valor;
        saldo = saldoField.getText();
        if(saldo !=  null) {
            valor = Double.parseDouble(saldo);
            if (valor > 0) {
                System.out.println(valor);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Falha de Cadastro");
                alert.setHeaderText("Informações inválidas");
                alert.setContentText("Saldo Inválido");
                alert.showAndWait();
            }
        }
    }

    public void setApp(MainJavaFX sis){
        this.sis = sis;
    }


    @FXML
    protected void btVoltar(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

}
