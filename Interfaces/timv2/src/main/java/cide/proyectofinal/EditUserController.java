package cide.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditUserController implements Initializable {
    @FXML
    private TextField txtCorreoElectronico, txtNombre, txtApellidos, txtTelefono, txtDireccion;
    @FXML
    private Label lblSaludo;

    private static final String UPDATE_NOMBRE = "UPDATE tim.usuarios SET nombre = ? WHERE nombre_usuario = ?";
    private static final String UPDATE_APELLIDOS = "UPDATE tim.usuarios SET apellidos = ? WHERE nombre_usuario = ?";
    private static final String UPDATE_TELEFONO = "UPDATE tim.usuarios SET telefono = ? WHERE nombre_usuario = ?";
    private static final String UPDATE_DIRECCION = "UPDATE tim.usuarios SET direccion = ? WHERE nombre_usuario = ?";
    private static final String UPDATE_CORREO_ELECTRONICO = "UPDATE tim.usuarios SET correo_electronico = ? WHERE nombre_usuario = ?";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String nombreUsuario = devolverValor("nombre");
            String apellidosUsuario = devolverValor("apellidos");
            String telefonoUsuario = devolverValor("telefono");
            String direccionUsuario = devolverValor("direccion");
            String correoUsuario = devolverValor("correo_electronico");

            String bienvenido = " " + lblSaludo.getText() + nombreUsuario + "!";
            lblSaludo.setText(bienvenido);
            txtNombre.setPromptText(nombreUsuario);
            txtApellidos.setPromptText(apellidosUsuario);
            txtTelefono.setPromptText(telefonoUsuario);
            txtDireccion.setPromptText(direccionUsuario);
            txtCorreoElectronico.setPromptText(correoUsuario);
        } catch (SQLException e) {
            mostrarAlerta("Error al cargar datos", "No se pudieron cargar los datos del usuario.");
        }
    }

    public void actualizarNombre() {
        String nombre = txtNombre.getText();
        if (!validarNombre(nombre)) {
            mostrarAlerta("Nombre inválido", "El nombre no puede estar vacío.");
            return;
        }

        actualizar(UPDATE_NOMBRE, nombre, "Nombre actualizado correctamente.");
    }

    public void actualizarApellidos() {
        String apellidos = txtApellidos.getText();
        if (!validarApellidos(apellidos)) {
            mostrarAlerta("Apellidos inválidos", "Los apellidos no pueden estar vacíos.");
            return;
        }

        actualizar(UPDATE_APELLIDOS, apellidos, "Apellidos actualizados correctamente.");
    }
    public void actualizarTelefono() {
        String telefono = txtTelefono.getText();
        if (!validarTelefono(telefono)) {
            mostrarAlerta("Teléfono inválido", "El teléfono debe tener un formato válido.");
            return;
        }
    
        actualizar(UPDATE_TELEFONO, telefono, "Teléfono actualizado correctamente.");
    }
    
    public void actualizarDireccion() {
        String direccion = txtDireccion.getText();
        if (!validarDireccion(direccion)) {
            mostrarAlerta("Dirección inválida", "La dirección no puede estar vacía.");
            return;
        }
    
        actualizar(UPDATE_DIRECCION, direccion, "Dirección actualizada correctamente.");
    }
    
    public void actualizarCorreoElectronico() {
        String correoElectronico = txtCorreoElectronico.getText();
        if (!validarCorreoElectronico(correoElectronico)) {
            mostrarAlerta("Correo electrónico inválido", "El correo electrónico debe tener un formato válido.");
            return;
        }
    
        actualizar(UPDATE_CORREO_ELECTRONICO, correoElectronico, "Correo electrónico actualizado correctamente.");
    }
    
    private void actualizar(String consulta, String valor, String mensajeExito) {
        try {
            PreparedStatement statement = App.conexion.prepareStatement(consulta);
            statement.setString(1, valor);
            statement.setString(2, devolverValor("nombre_usuario"));
            statement.executeUpdate();
            mostrarAlerta("Actualización exitosa", mensajeExito);
        } catch (SQLException e) {
            mostrarAlerta("Error al actualizar", "No se pudo actualizar la información del usuario.");
        }
    }
    
    private String devolverValor(String columna) throws SQLException {
        String consulta = "SELECT " + columna + " FROM tim.usuarios WHERE nombre_usuario = ?";
        PreparedStatement statement = App.conexion.prepareStatement(consulta);
        statement.setString(1, LoginController.usuario);
        ResultSet resultado = statement.executeQuery();
        resultado.next();
        return resultado.getString(columna);
    }
    
    private boolean validarNombre(String nombre) {
        return !nombre.trim().isEmpty();
    }
    
    private boolean validarApellidos(String apellidos) {
        return !apellidos.trim().isEmpty();
    }
    
    private boolean validarTelefono(String telefono) {
        Pattern pattern = Pattern.compile("\\d{9}");
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }
    
    private boolean validarDireccion(String direccion) {
        return !direccion.trim().isEmpty();
    }
    
    private boolean validarCorreoElectronico(String correoElectronico) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(correoElectronico);
        return matcher.matches();
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    

    public void irInicio() throws IOException {
        App.setRoot("inicio");
    }

    public void abrirPerfil() throws IOException {
        App.setRoot("perfilUsuario");
    }

    public void logOut() throws IOException {
       
        // Creamos un Alert de confirmación
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Está seguro de que desea cerrar la sesión?");
        alert.setContentText("Se perderán todos los datos no guardados.");
    
        // Mostramos el Alert y esperamos a que el usuario seleccione una opción
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Si el usuario ha confirmado la acción, cerramos la sesión
            // Aquí deberías hacer lo que sea necesario para cerrar la sesión del usuario
            // Por ejemplo, podrías borrar las credenciales almacenadas en la sesión o la
            // cookie de autenticación
    
            // Una vez que se haya cerrado la sesión, redirigimos al usuario a la página de login
            App.setRoot("login");
        } else {
            // Si el usuario ha cancelado la acción, simplemente cerramos el Alert y seguimos en la página actual
            alert.close();
        }
    }

    public void infoTarjeta() throws IOException {
        App.setRoot("tarjetasUsuario");
    }
}
