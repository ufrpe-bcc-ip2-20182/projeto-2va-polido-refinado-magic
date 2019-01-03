package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {

    private static Stage stage;
    private static Scene sceneLogin;
    private static Scene sceneCadastro;
    private static Scene sceneLogado;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("PROGASTOS");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/UI/view/Login.fxml"));
        sceneLogin = new Scene(fxmlLogin, 600,400);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("/UI/view/Cadastrar.fxml"));
        sceneCadastro = new Scene(fxmlCadastro, 600, 400);

        Parent fxmlLogado = FXMLLoader.load(getClass().getResource("/UI/view/Logado.fxml"));
        sceneLogado = new Scene(fxmlLogado, 600, 400);

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
        }
    }


    public static void main(String[] args){
        launch(args);
    }
}
