package UI.controller;

import UI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LogadoController {

    @FXML
    protected void btSair(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

    @FXML
    protected void btAdd(ActionEvent e){
        MainJavaFX.changeScreen("add");
    }
}
