package GUI.controller;

import GUI.MainJavaFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import sun.font.TextRecord;

import java.awt.*;

public class ApagarPagamentoController {
    @FXML private Button apagarPagButton;
    @FXML private TextField nomeDoPagTF;
    @FXML private Checkbox apagarTodosCB;
    @FXML private Checkbox apagarUmCB;
    @FXML private Button voltarButton;

    public void initialize(){

        this.apagarPagButton.setOnButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastro();
            }
        });
    }
}
