package UI.controller;

import UI.MainJavaFX;
import arquivo.Arquivo;
import arquivo.LerArquivo;
import arquivo.SalvarArquivo;
import beans.Conta;
import beans.Sistema;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CadastroController {

    @FXML private PasswordField passField;
    @FXML private PasswordField passOkField;
    @FXML private TextField nomeField;
    @FXML private TextField dataDeNascField;
    @FXML private TextField CPFField;
    @FXML private Button cadastrarButton;
    @FXML private TextField emailField;
    @FXML private TextField userField;
    @FXML private TextField saldoField;

    private MainJavaFX sis;

    Conta novaConta = new Conta();
    SalvarArquivo salvar = new SalvarArquivo();

    private Sistema sistema = new Sistema();
    private Arquivo arquivo = new Arquivo();
    private  LerArquivo lerArquivo = new LerArquivo();
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<String> logins = new ArrayList<>();

    public void initialize(){
        sistema = lerArquivo.ler(arquivo.getArquivo());
        this.sis = MainJavaFX.getInstance();
        contas = sistema.getContas();

        this.saldoField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastro();
            }
        });
        this.cadastrarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastro();
            }
        });
    }

    private void cadastro()
    {
        Stage stage = null;
        Parent root = null;
        boolean cadastroOk = false;

        String nome;
        boolean nomeok = false;
        nome = nomeField.getText();
        if( (!nome.equals("<NOVA-CONTA>")) && (!nome.equals("NOVO-BOLETO>")) && (!nome.equals("<FIM-BOLETO>")) && (!nome.equals("<FIM-CONTA>")) && (!nome.equals("<FIM-ARQUIVO>")) )
        {
            nomeok = true;
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha de Cadastro");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Nome Inválido");
            alert1.showAndWait();
        }

        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = null;
        java.util.Date data2 = null;
        boolean dataok = false;
        boolean dataFormato = true;

        try {
            data2 = f.parse(dataDeNascField.getText());
            data = f.parse(DateUtils.getDiadeHoje());
        } catch (ParseException e) {
            dataFormato = false;
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha de Cadastro");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Data contém formatação inválida");
            alert1.showAndWait();
        }

        if(dataFormato)
        {
            if (data.after(data2)) {
                dataok = true;
            } else {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Falha de Cadastro");
                alert1.setHeaderText("Informações inválidas");
                alert1.setContentText("Data inválida");
                alert1.showAndWait();
            }
        }

        String cpf;
        boolean cpfok = false;
        cpf = CPFField.getText();
        if(util.ValidationUtils.cpfcerto(cpf)){
            cpfok = true;
        }else{
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Falha de Cadastro");
            alert2.setHeaderText("Informações inválidas");
            alert2.setContentText("CPF inválido");
            alert2.showAndWait();
        }

        String email;
        boolean emailok = false;
        email = emailField.getText();
        if( (!email.equals("<NOVA-CONTA>")) && (!email.equals("NOVO-BOLETO>")) && (!email.equals("<FIM-BOLETO>")) && (!email.equals("<FIM-CONTA>")) && (!email.equals("<FIM-ARQUIVO>")) )
        {
            emailok = true;
        }
        else
        {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Falha de Cadastro");
            alert1.setHeaderText("Informações inválidas");
            alert1.setContentText("Email Inválido");
            alert1.showAndWait();
        }

        String usuario;
        boolean aux = false;
        boolean usuariook = false;
        usuario = userField.getText();

        for(int i = 0; i < contas.size(); i++) {
            logins.add(contas.get(i).getLogin());
        }
        for(int i = 0; i < logins.size(); i++) {
            if(logins.get(i).equals(usuario)){
                aux = true;
            }
        }
        if (!aux) {

            if( (!usuario.equals("<NOVA-CONTA>")) && (!usuario.equals("NOVO-BOLETO>")) && (!usuario.equals("<FIM-BOLETO>")) && (!usuario.equals("<FIM-CONTA>")) && (!usuario.equals("<FIM-ARQUIVO>")) )
            {
                usuariook = true;
            }
            else
            {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Falha de Cadastro");
                alert1.setHeaderText("Informações inválidas");
                alert1.setContentText("Usuário Inválido");
                alert1.showAndWait();
            }

        }else{
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("Falha de Cadastro");
            alert3.setHeaderText("Informações inválidas");
            alert3.setContentText("Usuário já Cadastrado");
            alert3.showAndWait();
        }

        String senha, senha2;
        boolean senhaok = false;
        senha = passField.getText();
        senha2 = passOkField.getText();
        if(senha.equals(senha2)){
            if( (!senha.equals("<NOVA-CONTA>")) && (!senha.equals("NOVO-BOLETO>")) && (!senha.equals("<FIM-BOLETO>")) && (!senha.equals("<FIM-CONTA>")) && (!senha.equals("<FIM-ARQUIVO>")) )
            {
               senhaok = true;
            }
            else
            {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Falha de Cadastro");
                alert1.setHeaderText("Informações inválidas");
                alert1.setContentText("Senha Inválida");
                alert1.showAndWait();
            }
        }else{
            Alert alert4 = new Alert(Alert.AlertType.ERROR);
            alert4.setTitle("Falha de Cadastro");
            alert4.setHeaderText("Informações inválidas");
            alert4.setContentText("Senhas não correspondem");
            alert4.showAndWait();
        }

        String saldo;
        Double valor = null;
        saldo = saldoField.getText();
        if(saldo !=  null) {
            valor = Double.parseDouble(saldo);
            if(valor < 0) {
                Alert alert5 = new Alert(Alert.AlertType.ERROR);
                alert5.setTitle("Falha de Cadastro");
                alert5.setHeaderText("Informações inválidas");
                alert5.setContentText("Saldo Inválido");
                alert5.showAndWait();
            }
        }

        if( (nomeok) && (emailok) && (usuariook) && (senhaok) && (cpfok) && (dataok) )
        {
            novaConta.setNome(nome);
            novaConta.setDatadenascimento(data2);
            novaConta.setDataDeCriacao(data);
            novaConta.setCpf(cpf);
            novaConta.setEmail(email);
            novaConta.setLogin(usuario);
            novaConta.setSenha(senha);
            novaConta.setSaldo(valor);
            this.sistema.addContas(novaConta);

            salvar.salvar(sistema, arquivo.getArquivo());

            Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
            alert5.setTitle("Aviso");
            alert5.setHeaderText("Cadastro Realizado com Sucesso");
            alert5.showAndWait();
        }

    }

    public void setApp(MainJavaFX sis){
        this.sis = sis;
    }


    @FXML
    protected void btVoltar(ActionEvent e){
        MainJavaFX.changeScreen("login");
    }

}
