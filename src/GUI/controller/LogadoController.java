package GUI.controller;

import GUI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class LogadoController {

    @FXML private TextField texto;

    public TextField getTexto() {
        return texto;
    }

    @FXML
    protected void btSair(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

    @FXML
    protected void btAdd(ActionEvent e){
        MainJavaFX.changeScreen("add");
    }

    @FXML
    protected void btMudarSenha(ActionEvent e){
        MainJavaFX.changeScreen("mudarSenha");
    }
}
