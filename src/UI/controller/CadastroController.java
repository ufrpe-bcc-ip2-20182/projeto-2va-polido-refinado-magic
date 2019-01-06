package UI.controller;

import UI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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





    @FXML
    protected void btVoltar(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

}
