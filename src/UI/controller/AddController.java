package UI.controller;

import UI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddController {
    @FXML
    protected void btAdd(ActionEvent e){
        MainJavaFX.changeScreen("add");
    }
}
