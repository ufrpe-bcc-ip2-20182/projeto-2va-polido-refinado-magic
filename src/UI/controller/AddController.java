package UI.controller;

import UI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Conta;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class AddController {
    @FXML protected void btVoltar(ActionEvent e){
        MainJavaFX.changeScreen("logado");
    }

    @FXML private Button addButton;
    @FXML private TextField nomeField;
    @FXML private TextField dataDoPagamentoField;
    @FXML private TextField valorPagField;
    @FXML private CheckBox pagoBox;
    @FXML private CheckBox aPagarBox;

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
/*
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
        });*/
    }
}
