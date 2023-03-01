package cide.proyectofinal;

import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ModificarNombreUsuario {
    @FXML
    private TextField txtNuevoNombre;

    public void modificarNuevoNombre() {
        // Declaramos una variable para la sentencia SQL
        Statement sentencia = null;
        
        // Creamos la consulta SQL para actualizar el nombre de usuario en la base de datos
        String query = "UPDATE " + App.bbdd + ".usuarios SET nombre_usuario = '" + txtNuevoNombre.getText()
                + "' WHERE (correo_electronico = '" + RecuperarUsuarioController.correoElectronico + "');";
        
        try {
            // Creamos una sentencia a partir de la conexión establecida con la base de datos
            sentencia = App.conexion.createStatement();
            
            // Ejecutamos la consulta SQL y obtenemos el número de filas actualizadas
            int filasActualizadas = sentencia.executeUpdate(query);
            
            // Si se han actualizado filas, se muestra una alerta de éxito y se redirige al usuario a la pantalla de inicio de sesión
            if (filasActualizadas > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("El nombre de usuario se ha actualizado correctamente");
                alert.showAndWait();
                App.setRoot("login");
            } 
            // Si no se han actualizado filas, se muestra una alerta de advertencia indicando que no se ha encontrado un usuario con el correo electrónico proporcionado
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("No se ha encontrado un usuario con el correo electrónico proporcionado");
                alert.showAndWait();
            }
        } catch (Exception e) {
            // Si se produce un error, se muestra una alerta de error con el mensaje de excepción correspondiente
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Ha ocurrido un error al actualizar el nombre de usuario: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
