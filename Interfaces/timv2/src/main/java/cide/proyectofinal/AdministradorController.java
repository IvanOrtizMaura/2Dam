package cide.proyectofinal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministradorController {
    @FXML
    private TableView<User> tablaUsuarios;

    @FXML
    private TableColumn<User, String> dni;

    @FXML
    private TableColumn<User, String> nombre;

    @FXML
    private TableColumn<User, String> apellidos;

    @FXML
    private TableColumn<User, String> direccion;

    @FXML
    private TableColumn<User, String> usuario;

    @FXML
    private TableColumn<User, String> telefono;

    @FXML
    private TableColumn<User, String> correo;

    @FXML
    private TableColumn<User, String> contrasena;

    @FXML
    private TableColumn<User, String> tipoUsuario;

    @FXML
    private TableColumn<User, Boolean> administrador;

    @FXML
    private TableColumn<User, String> fechaNacimiento;

    private ObservableList<User> listaUsuarios;
    @FXML
    public  TableView<Incidencias> tablaIncidencias;//Me da error si lo pongo estatico

    @FXML
    private TableColumn<Incidencias, Integer> id_incidencias;

    @FXML
    private TableColumn<Incidencias, String> titulo_incidencias;

    @FXML
    private TableColumn<Incidencias, String> origen_incidencias;

    @FXML
    private TableColumn<Incidencias, String> destino_incidencias;

    @FXML
    private TableColumn<Incidencias, String> tipo_incidencias;

    @FXML
    private TableColumn<Incidencias, String> descripcion_incidencias;

    private ObservableList<Incidencias> listaIncidencia;

    @FXML
    private TableView<Horario> tablaHorarios;

    @FXML
    private TableColumn<Horario, Integer> id;

    @FXML
    private TableColumn<Horario, String> ciudadOrigen;

    @FXML
    private TableColumn<Horario, String> ciudadDestino;

    @FXML
    private TableColumn<Horario, String> horaSalida;

    @FXML
    private TableColumn<Horario, String> horaLlegada;

    @FXML
    private TableColumn<Horario, String> tipo;

    private ObservableList<Horario> listaHorarios;


    public void initialize() {
        // configurarTablaUsuarios();
        configurarTablaHorarios();
        configurarTablaIncidencias();
        // llenarTablaUsuarios();
        llenarTablaHorarios();
        llenarTablaIncidencias();
    }

   

    private void configurarTablaIncidencias() {
        id_incidencias.setCellValueFactory(new PropertyValueFactory<>("id"));
        titulo_incidencias.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        origen_incidencias.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
        destino_incidencias.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
        tipo_incidencias.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        descripcion_incidencias.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }

    private void configurarTablaUsuarios() {
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        contrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        tipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));
        administrador.setCellValueFactory(new PropertyValueFactory<>("administrador"));
        fechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
    }

    private void configurarTablaHorarios() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ciudadOrigen.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
        ciudadDestino.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
        horaSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        horaLlegada.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    }
    public void llenarTablaIncidencias() {
        listaIncidencia = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = App.conexion.prepareStatement("SELECT * FROM tim.incidencias");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Incidencias incidencia = new Incidencias();
                incidencia.setId(rs.getInt("id_incidencias"));
                incidencia.setTitulo(rs.getString("titulo"));
                incidencia.setCiudadOrigen(rs.getString("ciudadOrigen"));
                incidencia.setCiudadDestino(rs.getString("ciudadDestino"));
                incidencia.setTipo(rs.getString("tipo"));
                incidencia.setDescripcion(rs.getString("descripcion"));
                listaIncidencia.add(incidencia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        tablaIncidencias.setItems(listaIncidencia);
    }

    public void llenarTablaUsuarios() {
        listaUsuarios = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = App.conexion.prepareStatement("SELECT * FROM tim.usuarios");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User usuario = new User(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("direccion"), rs.getString("nombre_usuario"), rs.getString("telefono"),
                        rs.getString("correo_electronico"), rs.getString("contrasena"), rs.getString("tipo_usuario"),
                        rs.getBoolean("es_administrador"), rs.getString("fecha_nacimiento"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        tablaUsuarios.setItems(listaUsuarios);
    }

    public void llenarTablaHorarios() {
        listaHorarios = FXCollections.observableArrayList();
        try {
            PreparedStatement stmt = App.conexion.prepareStatement("SELECT * FROM tim.horarios");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt("id"));
                horario.setCiudadOrigen(rs.getString("ciudadOrigen"));
                horario.setCiudadDestino(rs.getString("ciudadDestino"));
                horario.setHoraSalida(rs.getString("horaSalida"));
                horario.setHoraLlegada(rs.getString("horaLlegada"));
                horario.setTipo(rs.getString("tipo"));
                listaHorarios.add(horario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        tablaHorarios.setItems(listaHorarios);
    }

    @FXML
    private void eliminarIncidencias(ActionEvent event) {
        // Obtener la fila seleccionada en la tabla
        Incidencias incidencia = tablaIncidencias.getSelectionModel().getSelectedItem();

        if (incidencia != null) {
            // Obtener el DNI del usuario seleccionado
            Integer id = incidencia.getId();

            // Hacer una llamada a la base de datos para eliminar la fila correspondiente
            try {
                
                Statement stmt = App.conexion.createStatement();
                String query = "DELETE FROM tim.incidencias WHERE id_incidencias =" + id + "";
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Actualizar la tabla para reflejar los cambios en la base de datos
            tablaIncidencias.getItems().remove(incidencia);
            tablaIncidencias.refresh();
        }
    }
    @FXML
    private void eliminarHorario(ActionEvent event) {
        // Obtener la fila seleccionada en la tabla
        Horario horario = tablaHorarios.getSelectionModel().getSelectedItem();

        if (horario != null) {
            // Obtener el DNI del usuario seleccionado
            Integer id = horario.getId();

            // Hacer una llamada a la base de datos para eliminar la fila correspondiente
            try {
                
                Statement stmt = App.conexion.createStatement();
                String query = "DELETE FROM tim.horarios WHERE id =" + id + "";
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Actualizar la tabla para reflejar los cambios en la base de datos
            tablaHorarios.getItems().remove(horario);
            tablaHorarios.refresh();
        }
    }

    public void añadirIncidencias() throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("popaUpAñadirIncidencias.fxml")));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();        
    }
    public void añadirHorarios() throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("popaUpAñadirHorarios.fxml")));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();        
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

            // Una vez que se haya cerrado la sesión, redirigimos al usuario a la página de
            // login
            App.setRoot("login");
        } else {
            // Si el usuario ha cancelado la acción, simplemente cerramos el Alert y
            // seguimos en la página actual
            alert.close();
        }
    }

    public void infoTarjeta() throws IOException {
        // Se utiliza el método 'setRoot' de la clase App para establecer la vista
        // 'tarjetasUsuario'
        App.setRoot("tarjetasUsuario");
    }

}
