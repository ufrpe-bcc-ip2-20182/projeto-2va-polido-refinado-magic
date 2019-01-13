package GUI.controller;

import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Sistema;
import controller.ArquivoContas;
import controller.LerConta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

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

    @FXML
    protected void btExcluirConta(ActionEvent e)
    {
        Sistema sistema = new Sistema();
        Arquivo arquivo = new Arquivo();
        sistema = LerArquivo.ler(arquivo.getArquivo());
        ArquivoContas arquivoContas = new ArquivoContas();
        int indice = -1;

        try
        {
            indice = LerConta.ler(arquivoContas.getArquivo());
        }catch(IOException x)
        {
            x.printStackTrace();
        }

        sistema.getContas().remove(indice);

        SalvarArquivo salvarArquivo = new SalvarArquivo();
        salvarArquivo.salvar(sistema, arquivo.getArquivo());
    }
}
