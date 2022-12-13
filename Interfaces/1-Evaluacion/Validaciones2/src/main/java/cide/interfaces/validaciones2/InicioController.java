package cide.interfaces.validaciones2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;


public class InicioController {
    @FXML
    private TextField txtNumero, txtContraseña,txtFecha;
    @FXML
    private TextField txtLetra;
    public void validarNumeroOnClick(ActionEvent event){
        String numeros = txtNumero.getText();
        if (!(isNumeric(numeros))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error: Lo que ha introducio no és un número");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmacion");
            alert.setContentText("Correcto: Lo que ha introducido es un numero");
            alert.showAndWait();
        }
    }


    public void validaFechaOnClick(ActionEvent event){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = txtFecha.getText();

        String hoy = sdf.format(new Date());

    }
    public void validarContrasenaOnclick(ActionEvent event){
        String contraseña = "1234@.";
        String cadena = txtContraseña.getText();
        if (!(cadena.equals(contraseña))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error: Contraseña incorrecta ");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmacion");
            alert.setContentText("Correcto: Lo que ha introducido es un numero");
            alert.showAndWait();
        }
    }
    public void validarLetraOnClick(ActionEvent event) {
        String cadena = txtLetra.getText();
        if (!(isLetra(cadena))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error: Lo que ha introducio no és una letra");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmacion");
            alert.setContentText("Correcto: Lo que ha introducido es un numero");
            alert.showAndWait();
        }

    }
    public static boolean isLetra(String cadena){
        if (cadena.toUpperCase().matches("[A-Z]*")){
            return true;
        }else {
            return false;
        }

    }

    private boolean isNumeric(String numeros) {
        try{
            Integer.parseInt(numeros);
            return true;
        }catch (NumberFormatException nfe){

            
        }
    }
}
