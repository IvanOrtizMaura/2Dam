package cide.projectofinal.tim;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana {
    public static void abrirVentana(String nombre){
        try{
            FXMLLoader loader = new FXMLLoader(Ventana.class.getResource(nombre + ".fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("TIM");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.err.println("Hola");
            e.printStackTrace();
        }
    }
    public static void cerrarVentanaActual(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage actual = (Stage) source.getScene().getWindow();
        actual.close();
    }
}
