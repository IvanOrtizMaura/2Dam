package cide.proyectofinal;

import java.io.IOException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RecuperarContraseñaController {
    @FXML
    private TextField txtNuevaContraseña, txtConfirmarContraseña;

    public void restaurarContraseña() {
        Statement sentencia = null;
        String query = "UPDATE " + App.bbdd + ".usuarios SET contrasena = '" + txtConfirmarContraseña.getText()
                + "' WHERE (nombre_usuario = '" + LoginController.usuario + "')";
        try {
            // Verificar que las contraseñas ingresadas coinciden
            if (txtNuevaContraseña.getText().equals(txtConfirmarContraseña.getText())) {
                // Redirigir a la pantalla de inicio de sesión y actualizar la contraseña en la
                // base de datos
                App.setRoot("login");
                sentencia = App.conexion.createStatement();
                sentencia.executeUpdate(query);
                System.out.println("Contraseña cambiada");
            } else {
                // Si las contraseñas no coinciden, mostrar una alerta de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al restaurar contraseña");
                alert.setHeaderText(null);
                alert.setContentText("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            // Si ocurre un error al actualizar la contraseña, mostrar una alerta de error y
            // mostrar el mensaje de error en la consola
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al restaurar contraseña");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo cambiar la contraseña. Por favor, inténtalo de nuevo.");
            alert.showAndWait();
            System.out.println("Error al cambiar contraseña: " + e.getMessage());
        }
    }
    public void irLoginContrasena() throws IOException {
        App.setRoot("loginContraseña");
    }
}
