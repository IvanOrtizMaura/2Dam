package com.example.hotelera1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TablaReservaControlller {
    @FXML
    public void crearReserva(ActionEvent e){
        Ventana.cerrarVentanaActual(e);
        Ventana.abrirVentana("CrearReserva");
    }
}
