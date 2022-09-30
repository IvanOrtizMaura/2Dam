package com.example.hotelera1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CrearReservaController implements Initializable {
    @FXML
    private TextField textNombre, textTelefono;
    @FXML
    private ChoiceBox<String> choiceCocina, choiceTipoEvento;
    private String[] cocina = {"Bufet", "Carta", "Chef"};
    private String []tipoEvento = {"Banquete", "Jornada", "Congreso"};
    @FXML
    private DatePicker dateEvento;
    @FXML
    private Spinner spinnerPersona;
    @FXML
    private Button botonReservar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       choiceCocina.getItems().addAll(cocina);
       choiceTipoEvento.getItems().addAll(tipoEvento);

    }

}
