package GUI.controller;

import GUI.MainJavaFX;
import beans.Boleto;
import controller.ArquivoContas;
import controller.LerConta;
import javafx.scene.input.KeyCode;
import sun.font.TextRecord;
import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Conta;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.*;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import util.DateandGenerateUtils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ApagarPagamentoController {
    @FXML private Button apagarPagButton;
    @FXML private TextField nomeDoPagTF;
    @FXML private CheckBox apagarTodosCB;
    @FXML private CheckBox apagarUmCB;

    @FXML
    protected void voltarButton(ActionEvent e){
        MainJavaFX.changeScreen("logado");
    }


    public void initialize(){

        this.apagarPagButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                apagarPagButton();
            }
        });
    }

    private void apagarPagButton()
    {
        int indice = -1;

        Sistema sistema;
        Arquivo arquivo = new Arquivo();
        sistema = LerArquivo.ler(arquivo.getArquivo());
        ArquivoContas arquivoContas = new ArquivoContas();

        try
        {
            indice = LerConta.ler(arquivoContas.getArquivo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<Boleto> boletos = new ArrayList<>();

        boletos = sistema.getContas().get(indice).getBoletos();
        sistema.getContas().get(indice).getBoletos().clear();

        String nome = nomeDoPagTF.getText();

        if(apagarUmCB.isSelected() && apagarTodosCB.isSelected())
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Falha ao Apagar");
            alert2.setHeaderText("Erro");
            alert2.setContentText("Selecione apenas uma das caixas");
            alert2.showAndWait();
        }
        else if(apagarUmCB.isSelected())
        {
            for(int i=0;i<boletos.size();i++)
            {
                if(nome.equals(boletos.get(i).getNomeDoBoleto()))
                {
                    boletos.remove(i);
                    break;
                }
            }
        }
        else
        {
            for(int i=0;i<boletos.size();i++)
            {
                if(nome.equals(boletos.get(i).getNomeDoBoleto()))
                {
                    boletos.remove(i);
                }
            }
        }

        for(int i=0;i<boletos.size();i++)
        {
            sistema.getContas().get(indice).setBoletos(boletos.get(i));
        }

        SalvarArquivo salvarArquivo = new SalvarArquivo();
        salvarArquivo.salvar(sistema, arquivo.getArquivo());

        MainJavaFX.changeScreen("logado");


    }
}
