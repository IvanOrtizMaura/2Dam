package cide.proyectofinal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField txtUsuario; // declaramos un TextField para el usuario
    @FXML
    private Button btnSiguiente; // declaramos un botón siguiente
    public static String usuario = ""; // declaramos una variable estática usuario

    // método para verificar el usuario
    public void verificarUsuario(ActionEvent event) {
        String query = "select nombre_usuario from " + App.bbdd + ".usuarios where nombre_usuario = ?";
        try (PreparedStatement preparedStatement = App.conexion.prepareStatement(query)) {
            preparedStatement.setString(1, txtUsuario.getText());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    // si el usuario es correcto, lo guardamos en la variable estática usuario
                    usuario = rs.getString("nombre_usuario");
                    System.out.println(usuario);
                    App.setRoot("loginContraseña"); // cargamos la siguiente pantalla
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Usuario incorrecto");
                    alert.setContentText("El usuario introducido no existe");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al ejecutar la consulta");
                alert.setContentText("Ha ocurrido un error al comprobar el usuario");
                alert.showAndWait();
                System.err.println("Error al ejecutar la consulta");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al crear la sentencia preparada");
            alert.setContentText("Ha ocurrido un error al comprobar el usuario");
            alert.showAndWait();
            System.err.println("Error al crear la sentencia preparada");
            throw new RuntimeException(e);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la siguiente pantalla");
            alert.setContentText("Ha ocurrido un error al cargar la pantalla de contraseña");
            alert.showAndWait();
            System.out.println(e);
            System.err.println("Error al cargar la otra pantalla");
        }
    }

    // método para abrir la pantalla de recuperar usuario
    public void recuperarUsuario(ActionEvent event) throws IOException {
        App.setRoot("recuperarUsuario");
    }

    // método para abrir la pantalla de registro de usuario
    public void abrirRegistro() throws IOException {
        App.setRoot("registroUsuario");
    }
}
