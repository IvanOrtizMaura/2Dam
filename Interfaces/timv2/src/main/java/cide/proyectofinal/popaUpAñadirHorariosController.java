package cide.proyectofinal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class popaUpAñadirHorariosController {
    @FXML
    private TextField ciudadOrigen, ciudadDestino, horaSalida, horaLlegada,tipo;
    @FXML
    private void agregarHorario() {
        // Obtener los valores de los campos del formulario
        String ciudadOrigen = this.ciudadOrigen.getText();
        String ciudadDestino = this.ciudadDestino.getText();
        String horaSalida = this.horaSalida.getText();
        String horaLlegada = this.horaLlegada.getText();
        String tipo = this.tipo.getText();

        // Validar que se hayan ingresado todos los datos requeridos
        if (ciudadOrigen.isEmpty() || ciudadDestino.isEmpty() || horaSalida.isEmpty() || horaLlegada.isEmpty()
                || tipo.isEmpty()) {
            // Mostrar un mensaje de error si faltan datos
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, complete todos los campos.");
            alerta.showAndWait();
        } else {
            // Insertar la incidencia en la base de datos
            try {
                PreparedStatement stmt = App.conexion.prepareStatement(
                        "INSERT INTO tim.horarios (ciudadOrigen, ciudadDestino, horaSalida, horaLlegada, tipo) VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, ciudadOrigen);
                stmt.setString(2, ciudadDestino);
                stmt.setString(3, horaSalida);
                stmt.setString(4, horaLlegada);
                stmt.setString(5, tipo);
                stmt.executeUpdate();

                // Mostrar un mensaje de éxito
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setContentText("El horario se ha agregado correctamente.");
                alerta.showAndWait();
                App.setRoot("admin");

            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        }
    } 
}
