package com.example.hotelera1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CrearReservaController implements Initializable {
    @FXML
    private TextField textNombre, textTelefono;
    @FXML
    private ChoiceBox<String> choiceCocina;
    @FXML
    private ChoiceBox<String>choiceTipoEvento;
    private String[] cocina = {"Bufet", "Carta", "Chef"};
    private String []tipoEvento = {"Banquete", "Jornada", "Congreso"};
    @FXML
    private DatePicker dateEvento;
    @FXML
    private Spinner <Integer> spinnerPersona;
    @FXML
    private Button botonReservar;

    public void getDate(ActionEvent event){
        LocalDate myDate = dateEvento.getValue();
        String formatoFecha = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(formatoFecha);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceCocina.setValue("Carta");
        choiceTipoEvento.setValue("Banquete");

       choiceTipoEvento.getItems().addAll(tipoEvento);
       choiceCocina.getItems().addAll(cocina);
       SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
       valueFactory.setValue(1);
       spinnerPersona.setValueFactory(valueFactory);
    }


}
