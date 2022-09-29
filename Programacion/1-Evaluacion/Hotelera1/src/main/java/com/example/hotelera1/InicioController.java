package com.example.hotelera1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {
    @FXML
    private Button CrearFicha;
    @FXML
    public void crearFicha(ActionEvent e){
        Ventana.cerrarVentanaActual(e);
        Ventana.abrirVentana("CrearReserva");
    }
}
