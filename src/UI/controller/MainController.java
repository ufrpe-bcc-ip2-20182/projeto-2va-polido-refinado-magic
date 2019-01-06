package UI.controller;
import UI.MainJavaFX;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MainController {

    @FXML
    protected void btCadastro(ActionEvent e){
        MainJavaFX.changeScreen("cadastro");
    }

    @FXML
    protected void btLogin(ActionEvent e){
        MainJavaFX.changeScreen("logado");
    }

}


