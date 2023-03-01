package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginContraseñaController implements Initializable {

    @FXML
    private TextField txtContrasena;
    @FXML
    private Label lblBienvenido;
    @FXML
    private ImageView imageView;

    // Este método se ejecuta al inicializar el controlador
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String imagen = null;
        Image img;
        try {
            PreparedStatement sentencia = App.conexion
                    .prepareStatement("SELECT imagen FROM tim.usuarios WHERE nombre_usuario = ?");
            sentencia.setString(1, LoginController.usuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                imagen = rs.getString("imagen");
            }
        } catch (SQLException ex) {
            // Manejar la excepción de manera adecuada, por ejemplo, mostrando un mensaje de
            // error
            ex.printStackTrace();
        }

        if (imagen == null) {
            img = new Image(getClass().getResourceAsStream("fotos/UsuarioLogin.png"));
        } else {
            img = new Image(getClass().getResourceAsStream(imagen));
        }
        imageView.setImage(img);

        String bienvenido = lblBienvenido.getText() + LoginController.usuario;
        lblBienvenido.setText(bienvenido);

    }

    // Este método se ejecuta al pulsar el botón de verificar contraseña
    public void verificarContraseña(ActionEvent event) {
        Statement sentencia;
        boolean administrador;
        // Se construye la consulta para obtener la contraseña del usuario
        // correspondiente
        String query = "select * from " + App.bbdd + ".usuarios where nombre_usuario= '"
                + LoginController.usuario + "' and contrasena= '" + txtContrasena.getText() + "'";
        try {
            // Se crea una instancia de Statement para ejecutar la consulta
            sentencia = App.conexion.createStatement();
            // Se ejecuta la consulta y se obtiene el resultado en un objeto ResultSet
            ResultSet rs = sentencia.executeQuery(query);
            // Si se ha encontrado un resultado, se muestra un mensaje de bienvenida y se
            // carga la pantalla de inicio
            if (rs.next()) {
                System.out.println(rs.getString("contrasena"));
                administrador = rs.getBoolean("es_administrador");
                if (administrador == true) {
                    App.setRoot("admin");
                } else {
                    App.setRoot("inicio");

                }
                // Si no se ha encontrado un resultado, se muestra un mensaje de error indicando
                // que la contraseña es incorrecta
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Contraseña incorrecta");
                alert.setContentText("La contraseña introducida no es correcta");
                alert.showAndWait();
            }
            rs.close();
        } catch (SQLException e) {
            // Si se ha producido un error al ejecutar la consulta, se muestra un mensaje de
            // error indicando el problema
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al ejecutar la consulta");
            alert.setContentText("Ha ocurrido un error al comprobar la contraseña");
            alert.showAndWait();
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Si se ha producido un error al cargar la siguiente pantalla, se muestra un
            // mensaje de error indicando el problema
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la siguiente pantalla");
            alert.setContentText("Ha ocurrido un error al cargar la pantalla");
            alert.showAndWait();
            System.err.println(e);
        }
    }

    public void recuperarContraseña() {
        try {
            App.setRoot("recuperarContraseña");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la pantalla");
            alert.setContentText("Ha ocurrido un error al cargar la pantalla de recuperar contraseña");
            alert.showAndWait();
            System.err.println(e);
        }
    }
    public void irLogin() throws IOException {
        App.setRoot("login");
    }

}
