package UI.controller;

import UI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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



}
