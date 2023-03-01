package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TarjetasUsuarioController implements Initializable {

    // Componentes gráficos
    @FXML
    private Label lblNumeroTarjeta, lblSaldo;
    @FXML
    private TextField txtSaldo;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Actualizamos los datos de la tarjeta al iniciar la pantalla
        lblNumeroTarjeta.setText(HomeController.numeroTarjeta);
        lblSaldo.setText(HomeController.saldoTarjeta);
    }

    // Método para añadir saldo a la tarjeta
    public void añadirSaldo() {
        // Obtenemos el saldo introducido por el usuario
        String nuevoSaldo = txtSaldo.getText();

        // Verificamos que se haya introducido un valor numérico
        if (!nuevoSaldo.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("El saldo debe ser un valor numérico");
            alert.showAndWait();
            return;
        }

        // Convertimos los saldos a enteros para realizar la suma
        int saldoActual = Integer.parseInt(HomeController.saldoTarjeta.split(" ")[0]);
        int saldoAAñadir = Integer.parseInt(nuevoSaldo);

        // Calculamos el nuevo saldo
        int saldoNuevo = saldoActual + saldoAAñadir;

        // Creamos la consulta para actualizar el saldo en la base de datos
        String query = "UPDATE " + App.bbdd + ".tarjetas SET saldo = ? WHERE numero_tarjeta = ?";

        try {
            // Preparamos la consulta
            PreparedStatement statement = App.conexion.prepareStatement(query);

            // Añadimos los valores a la consulta
            statement.setInt(1, saldoNuevo);
            statement.setString(2, HomeController.numeroTarjeta);

            // Ejecutamos la consulta
            statement.executeUpdate();

            // Actualizamos la información de la tarjeta en la pantalla
            lblSaldo.setText(saldoNuevo + "€");

            // Mostramos una alerta de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("El saldo se ha actualizado correctamente");
            alert.showAndWait();

        } catch (SQLException e) {
            // Si se produce un error en la consulta, mostramos una alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Ha ocurrido un error al añadir saldo a la tarjeta: " + e.getMessage());
            alert.showAndWait();
        }
    }
    public void irInicio() throws IOException {
        // Se utiliza el método 'setRoot' de la clase App para establecer la vista
        // 'inicio'
        App.setRoot("inicio");
    }

    public void abrirPerfil() throws IOException {
        // Se utiliza el método 'setRoot' de la clase App para establecer la vista
        // 'perfilUsuario'
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
        // Se utiliza el método 'setRoot' de la clase App para establecer la vista
        // 'tarjetasUsuario'
        App.setRoot("tarjetasUsuario");
    }
}
