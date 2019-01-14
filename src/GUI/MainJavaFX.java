package GUI;

import arquivo.Arquivo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {

    private static MainJavaFX instance;

    public static MainJavaFX getInstance(){
        if(instance == null){
            instance = new MainJavaFX();
        }
        return instance;
    }

    private Stage primaryStage;
    private static Stage stage;
    private static Scene sceneLogin;
    private static Scene sceneCadastro;
    private static Scene sceneLogado;
    private static Scene sceneAdd;
    private static Scene sceneMudarSenha;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("PROGASTOS");


        Arquivo arquivo = new Arquivo();

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        sceneLogin = new Scene(fxmlLogin, 600,400);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("view/Cadastrar.fxml"));
        sceneCadastro = new Scene(fxmlCadastro, 600, 400);

        Parent fxmlLogado = FXMLLoader.load(getClass().getResource("view/Logado.fxml"));
        sceneLogado = new Scene(fxmlLogado, 600, 400);

        Parent fxmlAdd = FXMLLoader.load(getClass().getResource("view/Add.fxml"));
        sceneAdd = new Scene(fxmlAdd, 600, 400);

        Parent fxmlMudarSenha = FXMLLoader.load(getClass().getResource("view/MudarSenha.fxml"));
        sceneMudarSenha = new Scene(fxmlMudarSenha, 600, 400);

        primaryStage.setScene(sceneLogin);
        primaryStage.show();
    }

    public static void changeScreen(String scr){

        switch(scr){
            case "login":
                stage.setScene(sceneLogin);
                break;
            case "cadastro":
                stage.setScene(sceneCadastro);
                break;
            case "logado":
                stage.setScene(sceneLogado);
                break;
            case "add":
                stage.setScene(sceneAdd);
                break;
            case "mudarSenha":
                stage.setScene(sceneMudarSenha);
        }
    }

    public void changeStage(Stage stage){
        this.primaryStage = stage;
    }

    public Stage getPrimaryStage(){
        return this.primaryStage;
    }

    public static void main(String[] args){
        launch(args);
    }
}
