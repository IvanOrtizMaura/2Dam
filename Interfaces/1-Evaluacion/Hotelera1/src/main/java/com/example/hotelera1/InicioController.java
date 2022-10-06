package com.example.hotelera1;

import com.almasb.fxgl.multiplayer.ActionEndReplicationEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    @FXML
    private Button CrearFicha;
    @FXML
    private ChoiceBox<String> choiceHoteles;
    private String[] hoteles = {"Miramar", "Melià"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceHoteles.setValue("Miramar");
        choiceHoteles.getItems().addAll(hoteles);
        choiceHoteles.setOnAction(this::getHotel);
    }
    public void getHotel(ActionEvent event){
        String myHotel = choiceHoteles.getValue();
    }
    @FXML
    public void abrirReservas(ActionEvent e){
        Ventana.cerrarVentanaActual(e);
        Ventana.abrirVentana("TablaDeReservas");
    }



}
