package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class RegistroUsuarioController implements Initializable {

    @FXML
    private TextField txtNombre, txtApellidos, txtnombreUsuario, txtTelefono, txtContraseña, txtContraseña1, txtDNI,
            txtFechaNacimiento, txtCorreoElectronico, txtDireccion, btnRegistrar;
    @FXML
    private CheckBox chkAcepto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar elementos de la vista
        // ...
    }

    public void registrarUsuario(ActionEvent event) {
        try {
            // Validar que se hayan ingresado todos los campos
            if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty()
                    || txtnombreUsuario.getText().isEmpty()
                    || txtTelefono.getText().isEmpty() || txtContraseña.getText().isEmpty()
                    || txtContraseña1.getText().isEmpty() || txtDNI.getText().isEmpty()
                    || txtFechaNacimiento.getText().isEmpty() || txtCorreoElectronico.getText().isEmpty()
                    || txtDireccion.getText().isEmpty()) {
                throw new IllegalArgumentException("Debe llenar todos los campos.");
            }
            // Validar que las contraseñas coincidan
            if (!txtContraseña.getText().equals(txtContraseña1.getText())) {
                throw new IllegalArgumentException("Las contraseñas no coinciden.");
            }
            // Validar que se haya aceptado el acuerdo de términos y condiciones
            if (!chkAcepto.isSelected()) {
                throw new IllegalArgumentException("Debe aceptar los términos y condiciones.");
            }

            // Insertar el nuevo usuario en la base de datos
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String nombreUsuario = txtnombreUsuario.getText();
            String telefono = txtTelefono.getText();
            String contraseña = txtContraseña.getText();
            String dni = txtDNI.getText();
            String fechaNacimiento = txtFechaNacimiento.getText();
            String correoElectronico = txtCorreoElectronico.getText();
            String direccion = txtDireccion.getText();
            String tipoUsuario = "adulto";

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNacimientoDate = formatter.parse(fechaNacimiento);
            Date mayorEdadDate = formatter.parse("01/01/2009");

            if (fechaNacimientoDate.after(mayorEdadDate)) {
                tipoUsuario = "niño";
            }

            // Aquí va la lógica de la inserción en la base de datos

            PreparedStatement ps = App.conexion.prepareStatement(
                    "INSERT INTO tim.usuarios (nombre, apellidos, nombre_usuario, telefono, contrasena, dni, fecha_nacimiento, correo_electronico, direccion, tipo_usuario, es_administrador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, nombreUsuario);
            ps.setString(4, telefono);
            ps.setString(5, contraseña);
            ps.setString(6, dni);
            ps.setString(7, fechaNacimiento);
            ps.setString(8, correoElectronico);
            ps.setString(9, direccion);
            ps.setString(10, tipoUsuario);
            ps.setBoolean(11, false);
            ps.executeUpdate();

            PreparedStatement ps2 = App.conexion.prepareStatement(
                    "INSERT INTO tim.tarjetas (saldo, dni) VALUES (0, ?)");
            ps2.setString(1, dni);
            ps2.executeUpdate();

            System.out.println("Usuario registrado exitosamente!");
            App.setRoot("login");

        } catch (SQLException ex) {
            System.out.println("Error al registrar usuario: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Error al parsear fecha: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            alert.showAndWait();
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            alert.showAndWait();
        }
    }
    public void irLogin() throws IOException {
        App.setRoot("login");
    }

}
