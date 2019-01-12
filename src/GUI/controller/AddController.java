package GUI.controller;

import GUI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Boleto;
import beans.Conta;
import beans.Sistema;
import controller.ArquivoContas;
import controller.LerConta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import util.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private boolean pagamento;

    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();

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

        int indice = -1;

        ArquivoContas arquivoContas = new ArquivoContas();

        try
        {
            indice = LerConta.ler(arquivoContas.getArquivo());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String nome = nomeField.getText();
        boolean nomeOk = false;
        if( (!nome.equals("<NOVA-CONTA>")) && (!nome.equals("NOVO-BOLETO>")) && (!nome.equals("<FIM-BOLETO>")) && (!nome.equals("<FIM-CONTA>")) && (!nome.equals("<FIM-ARQUIVO>")) )
        {
            nomeOk = true;
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha ao Adicionar Pagamento");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Nome Inválido");
            alert1.showAndWait();
        }

        double valor = Double.parseDouble(valorPagField.getText());
        boolean valorOk = false;
        if(valor>0)
        {
            valorOk = true;
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha ao Adicionar Pagamento");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Valor Inválido");
            alert1.showAndWait();
        }

        boolean pagoBoxOk = false;
        if(pagoBox.isSelected())
        {
            pagamento = true;
            pagoBoxOk = true;
        }

        if(aPagarBox.isSelected())
        {
            pagamento = false;
            pagoBoxOk = true;
        }

        if( (pagoBox.isSelected()) && (aPagarBox.isSelected()) )
        {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Falha ao Adicionar");
            alert2.setHeaderText("Informações inválidas");
            alert2.setContentText("Selecione apenas uma das caixas");
            alert2.showAndWait();
        }

        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date data2 = null;
        java.util.Date data = null;
        boolean dataFormato = true;

        try {
            data2 = f.parse(dataDoPagamentoField.getText());
            data = f.parse(DateUtils.getDiadeHoje());
        } catch (ParseException e) {
            dataFormato = false;
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha de Cadastro");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Data contém formatação inválida");
            alert1.showAndWait();
        }


        if( (nomeOk) && (valorOk) && (pagoBoxOk) && (dataFormato) )
        {
            Boleto novoBoleto = new Boleto();

            novoBoleto.setNomeDoBoleto(nome);
            novoBoleto.setValor(valor);
            novoBoleto.setPagamento(pagamento);
            novoBoleto.setDataDeCriacao(data);
            novoBoleto.setDataDeVencimento(data2);
            double pagar = sistema.getContas().get(indice).getSaldo();
            if(pagar-valor >= 0)
            {
                sistema.getContas().get(indice).setSaldo(pagar-valor);
            }
            else
            {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Falha ao Adicionar Pagamento");
                alert1.setHeaderText("Informações inválidas");
                alert1.setContentText("Saldo da Conta insuficiente");
                alert1.showAndWait();
            }
            sistema.getContas().get(indice).setBoletos(novoBoleto);

            nomeField.clear();
            dataDoPagamentoField.clear();
            valorPagField.clear();
            if(pagoBox.isSelected())
            {
                pagoBox.fire();
            }
            else if(aPagarBox.isSelected())
            {
                aPagarBox.fire();
            }

            Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
            alert5.setTitle("Aviso");
            alert5.setHeaderText("Boleto adicionado com sucesso!");
            SalvarArquivo salvarArquivo = new SalvarArquivo();

            salvarArquivo.salvar(sistema, arquivo.getArquivo());
        }
    }
}
