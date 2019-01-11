package GUI.controller;

import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import beans.Conta;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    private MainJavaFX sis;

    private Sistema sistema = new Sistema();
    private Arquivo arquivo = new Arquivo();
    private LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<String> logins = new ArrayList<>();
    Boolean pagamento;

    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        contas = sistema.getContas();

        this.addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                adicionar();
            }
        });
    }

    public void adicionar()
    {
        Stage stage = null;
        Parent root = null;

        String nome = nomeField.getText();

        Double valor = Double.parseDouble(valorPagField.getText());


        if(pagoBox.isSelected()==true)
        {
            pagamento = true;
        }

        if(aPagarBox.isSelected()==true)
        {
            pagamento = false;
        }

        if( (pagoBox.isSelected()==true) && (aPagarBox.isSelected()==true) )
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Falha ao Adicionar");
            alert2.setHeaderText("Informações inválidas");
            alert2.setContentText("Selecione apenas uma das caixas");
            alert2.showAndWait();
        }

    }
}
