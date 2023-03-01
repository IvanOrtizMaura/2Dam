package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class HomeController implements Initializable {

    // Etiquetas de la interfaz gráfica
    @FXML
    private Label lblLinea3, lblLinea2, lblIncidencia2, lblLinea, lblRuta, lblNumeroTarjeta, lblNombre, lblTipoUsuario,
            lblSaldo, lblIncidencia1;

    // Variable estática para almacenar el número de tarjeta
    public static String numeroTarjeta = mostrarNumeroTarjeta();

    // Variable estática para almacenar el saldo de la tarjeta
    public static String saldoTarjeta;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Obtener los valores de la base de datos
        String nombreTarjeta = mostrarNombre();
        String tipoUsuarioTarjeta = mostrarTipoUsuario();
        String linea = mostrarLinea(1);
        String linea2 = mostrarLinea(2);
        String linea3 = mostrarLinea(3);
        String incidencia1 = mostrarIncidencia(1);
        String incidencia2 = mostrarIncidencia(2);
        saldoTarjeta = mostrarSaldo();

        // Asignar los valores a las etiquetas de la interfaz gráfica
        lblNumeroTarjeta.setText(numeroTarjeta);
        lblNombre.setText(nombreTarjeta);
        lblTipoUsuario.setText(tipoUsuarioTarjeta);
        lblSaldo.setText(saldoTarjeta);
        lblLinea.setText(linea);
        lblLinea2.setText(linea2);
        lblLinea3.setText(linea3);
        lblIncidencia1.setText(incidencia1);
        lblIncidencia2.setText(incidencia2);
    }

    // Método para obtener el texto de la incidencia especificada
    public String mostrarIncidencia(int numIncidencia) {
        String query = "SELECT titulo FROM tim.incidencias ORDER BY id_incidencias DESC LIMIT 2";
        try (PreparedStatement statement = App.conexion.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (numIncidencia == 1) {
                    return rs.getString("titulo");
                } else {
                    // Si se pide la segunda incidencia, se llama a next() una vez más
                    rs.next();
                    return rs.getString("titulo");
                }
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String mostrarLinea(int offset) {
        // Se define la consulta para seleccionar el id de la tabla 'horarios'
        // correspondiente a la línea solicitada.
        // La cláusula WHERE filtra la tabla por los valores de 'id' mayores o iguales
        // al valor del parámetro 'offset',
        // y la cláusula LIMIT se utiliza para limitar los resultados a un solo
        // resultado.
        String query = "SELECT id FROM tim.horarios WHERE id >= ? ORDER BY id LIMIT 1";
        try (PreparedStatement statement = App.conexion.prepareStatement(query)) {
            // Se establece el valor del parámetro 'offset' en la consulta preparada
            statement.setInt(1, offset);
            // Se ejecuta la consulta y se obtiene el conjunto de resultados
            ResultSet rs = statement.executeQuery();
            // Si la consulta devuelve al menos un resultado
            if (rs.next()) {
                // Se obtiene el valor del id de la tabla 'horarios' correspondiente a la línea
                // solicitada
                String linea = rs.getString("id");
                // Se devuelve una cadena que indica la línea correspondiente al id obtenido
                return "Linea " + linea;
            }
            // Si la consulta no devuelve ningún resultado, se devuelve una cadena vacía
            return "";
        } catch (SQLException e) {
            // Si ocurre una excepción al ejecutar la consulta, se imprime la traza del
            // error y se devuelve una cadena vacía
            e.printStackTrace();
            return "";
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

    public void irListaHorarios() throws IOException {
        App.setRoot("ListaHorarios");
    }
    public void irListaIncidencias() throws IOException {
        App.setRoot("ListaIncidencias");
    }


    public static String mostrarNumeroTarjeta() {
        String numeroTarjeta = "";
        String query = "SELECT tim.tarjetas.numero_tarjeta from tim.usuarios inner join tim.tarjetas on tim.usuarios.dni = tim.tarjetas.dni where nombre_usuario = ?";
        try (PreparedStatement statement = App.conexion.prepareStatement(query)) {
            // Se establece el valor del parámetro en la consulta
            statement.setString(1, LoginController.usuario);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                numeroTarjeta = (rs.getString("numero_tarjeta"));
                return numeroTarjeta;
            }
            return "";
        } catch (SQLException e) {
            // Se imprime la excepción en caso de que ocurra algún error
            e.printStackTrace();
            return "";
        }
    }

    public static String mostrarNombre() {
        String nombre = "";
        String apellidos = "";
        String query = "SELECT tim.usuarios.nombre, tim.usuarios.apellidos from tim.usuarios inner join tim.tarjetas on tim.usuarios.dni = tim.tarjetas.dni where nombre_usuario = ?";
        try (PreparedStatement statement = App.conexion.prepareStatement(query)) {
            // Se establece el valor del parámetro en la consulta
            statement.setString(1, LoginController.usuario);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nombre = (rs.getString("nombre"));
                apellidos = (rs.getString("apellidos"));
                return nombre + " " + apellidos;
            }
            return "";
        } catch (SQLException e) {
            // Se imprime la excepción en caso de que ocurra algún error
            e.printStackTrace();
            return "";
        }
    }

    public static String mostrarTipoUsuario() {
        // Crea una variable para guardar el tipo de usuario
        String tipoUsuario = "";
        // Crea un objeto Statement para realizar la consulta a la base de datos
        Statement sentencia = null;
        String query = "SELECT tim.usuarios.tipo_usuario from tim.usuarios inner join tim.tarjetas on tim.usuarios.dni = tim.tarjetas.dni where nombre_usuario = '"
                + LoginController.usuario + "'";
        try {
            // Crea el objeto Statement para ejecutar la consulta
            sentencia = App.conexion.createStatement();
            // Ejecuta la consulta y guarda el resultado en un objeto ResultSet
            ResultSet rs = sentencia.executeQuery(query);
            // Si el resultado contiene al menos una fila, guarda el valor de la columna
            // "tipoUsuario" en la variable correspondiente
            if (rs.next()) {
                tipoUsuario = (rs.getString("tipo_usuario"));
                return tipoUsuario;
            }
            // Si no hay resultados, devuelve una cadena vacía
            return "";
        } catch (Exception e) {
            // Si se produce una excepción, devuelve una cadena vacía y muestra el error en
            // la consola
            e.printStackTrace();
            return "";
        } finally {
            // Cierra el objeto Statement
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String mostrarSaldo() {
        String saldo = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT tim.tarjetas.saldo from tim.usuarios inner join tim.tarjetas on tim.usuarios.dni = tim.tarjetas.dni where nombre_usuario = ?"; // Usamos
                                                                                                                                                             // ?
                                                                                                                                                             // como
                                                                                                                                                             // placeholder
                                                                                                                                                             // para
                                                                                                                                                             // el
                                                                                                                                                             // parámetro,
                                                                                                                                                             // lo
                                                                                                                                                             // que
                                                                                                                                                             // hace
                                                                                                                                                             // más
                                                                                                                                                             // seguro
                                                                                                                                                             // y
                                                                                                                                                             // eficiente
                                                                                                                                                             // el
                                                                                                                                                             // uso
                                                                                                                                                             // de
                                                                                                                                                             // sentencias
                                                                                                                                                             // preparadas

        try {
            ps = App.conexion.prepareStatement(query);
            ps.setString(1, LoginController.usuario); // Asignamos el valor del parámetro en la posición 1
            rs = ps.executeQuery();
            if (rs.next()) {
                saldo = rs.getString("saldo");
                return saldo + " €";
            }
            return "";
        } catch (SQLException e) {
            // Manejamos las excepciones SQLException, que pueden ocurrir durante la
            // conexión o consulta a la base de datos
            System.err.println("Error al mostrar saldo: " + e.getMessage());
            return "";
        } finally {
            // En el bloque finally, cerramos los objetos ResultSet, PreparedStatement y
            // Statement
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

}
