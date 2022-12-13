package dam.interfaces.validaciones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class InicioController {
    @FXML
    private Button btnLetra, btnNumeor;
    @FXML
    public void validarnumeros(ActionEvent event){
        String numeros = btnNumeor.getText();
        if (!(isNumeric(numeros))){
            alertError();
        }
    }
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
    @FXML
    public void alertError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Error: Lo que ha introducio no es correcto");
        alert.showAndWait();

    }
}
