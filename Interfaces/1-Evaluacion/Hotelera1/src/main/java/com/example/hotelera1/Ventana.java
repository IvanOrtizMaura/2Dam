package com.example.hotelera1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Ventana {
    public static void gestionarVentanas(ArrayList<Button> ventanas){
        ventanas.forEach(b -> b.setOnAction(e -> {
            Ventana.cerrarVentanaActual(e);
            Ventana.abrirVentana(b.getId());
        }));
    }
    public static void cerrarVentanaActual(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage actual = (Stage) source.getScene().getWindow();
        actual.close();

    }

    public static void abrirVentana(String nombre) {
        try {
            FXMLLoader loader = new FXMLLoader(Ventana.class.getResource(nombre + ".fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Hoteleria");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
