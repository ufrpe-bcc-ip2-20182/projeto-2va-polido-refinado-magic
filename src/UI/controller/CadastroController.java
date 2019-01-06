package UI.controller;

import UI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CadastroController {



    @FXML
    protected void btVoltar(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

}
