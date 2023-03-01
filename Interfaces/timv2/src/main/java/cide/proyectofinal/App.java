package cide.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Connection conexion;

    public static String bbdd = "tim";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setResizable(false);
        stage.setScene(scene);
        BBDDConnection();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void BBDDConnection() {
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "1v4nG00n3r45");

            if(conexion != null){
                System.out.println("Conectado");
            }
        
        }catch(SQLException e){
            e.printStackTrace();
            System.exit(-1);        }
        
    }

    public static void main(String[] args) {
        launch();
    }

}