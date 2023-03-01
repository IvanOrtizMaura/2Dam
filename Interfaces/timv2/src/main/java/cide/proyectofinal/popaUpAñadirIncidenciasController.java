package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class popaUpAñadirIncidenciasController implements Initializable {
    @FXML
    private TextField titulo, ciudadOrigen, tipo, ciudadDestino;
    @FXML
    private TextArea descripcion;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    //     titulo.setText(AdministradorController.tablaIncidencias.getSelectionModel().getSelectedItem().getTitulo());
    //     ciudadOrigen.setText(AdministradorController.tablaIncidencias.getSelectionModel().getSelectedItem().getCiudadOrigen());
     }

    @FXML
    private void agregarIncidencia() {
        // Obtener los valores de los campos del formulario
        String titulo = this.titulo.getText();
        String ciudadOrigen = this.ciudadOrigen.getText();
        String ciudadDestino = this.ciudadDestino.getText();
        String tipo = this.tipo.getText();
        String descripcion = this.descripcion.getText();

        // Validar que se hayan ingresado todos los datos requeridos
        if (titulo.isEmpty() || ciudadOrigen.isEmpty() || ciudadDestino.isEmpty() || tipo.isEmpty()
                || descripcion.isEmpty()) {
            // Mostrar un mensaje de error si faltan datos
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, complete todos los campos.");
            alerta.showAndWait();
        } else {
            // Insertar la incidencia en la base de datos
            try {
                PreparedStatement stmt = App.conexion.prepareStatement(
                        "INSERT INTO tim.incidencias (titulo, ciudadOrigen, ciudadDestino, tipo, descripcion) VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, titulo);
                stmt.setString(2, ciudadOrigen);
                stmt.setString(3, ciudadDestino);
                stmt.setString(4, tipo);
                stmt.setString(5, descripcion);
                stmt.executeUpdate();

                // Mostrar un mensaje de éxito
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setContentText("La incidencia se ha agregado correctamente.");
                alerta.showAndWait();
                App.setRoot("admin");

            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    

    // @FXML
    // private void modificarIncidencia(ActionEvent event) {
    //     Incidencias incidenciaSeleccionada = AdministradorController.tablaIncidencias.getSelectionModel().getSelectedItem();
              
    //     if (incidenciaSeleccionada != null) {

    //         try {
    //             PreparedStatement stmt = App.conexion.prepareStatement(
    //                     "UPDATE tim.incidencias SET titulo = ?, ciudadOrigen = ?, ciudadDestino = ?, tipo = ?, descripcion = ? WHERE id = ?");
    //             // Actualizar incidencia en la base de datos

    //             stmt.setString(1, incidenciaSeleccionada.getTitulo());
    //             stmt.setString(2, incidenciaSeleccionada.getCiudadOrigen());
    //             stmt.setString(3, incidenciaSeleccionada.getCiudadDestino());
    //             stmt.setString(4, incidenciaSeleccionada.getTipo());
    //             stmt.setString(5, incidenciaSeleccionada.getDescripcion());
    //             stmt.setInt(6, incidenciaSeleccionada.getId());
    //             stmt.executeUpdate();

    //             // Mostrar un mensaje de éxito
    //             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    //             alerta.setHeaderText(null);
    //             alerta.setContentText("La incidencia se ha actualizado correctamente.");
    //             alerta.showAndWait();
    //             App.setRoot("admin");

    //         } catch (IOException | SQLException ex) {
    //             ex.printStackTrace();
    //         }
    //     } else {
    //         Alert alert = new Alert(AlertType.ERROR);
    //         alert.setTitle("Error");
    //         alert.setHeaderText("No se ha seleccionado ninguna incidencia");
    //         alert.setContentText("Por favor, seleccione una incidencia de la tabla antes de modificar");
    //         alert.showAndWait();
    //     }
    // }

    

}
