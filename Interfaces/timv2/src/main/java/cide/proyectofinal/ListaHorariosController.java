package cide.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ListaHorariosController implements Initializable {
    @FXML
    private Pane panel;
    @FXML
    private ComboBox<String> filtro;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> opciones = FXCollections.observableArrayList("Todos", "Bus", "Tren", "Metro");
        filtro.setItems(opciones);
        filtro.setValue("Todos");
        actualizarTabla("SELECT * FROM tim.horarios");
        filtro.setOnAction(e -> {
            String valor = filtro.getValue().toString();
            if (valor.equals("Todos")) {
                actualizarTabla("SELECT * FROM tim.horarios");
            } else {
                actualizarTabla("SELECT * FROM tim.horarios WHERE tipo='" + valor.toLowerCase() + "'");
            }
        });

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

    private void actualizarTabla(String query) {
        try (PreparedStatement statement = App.conexion.prepareStatement(query);
                ResultSet rs = statement.executeQuery()) {
            final String BORDER_STYLE = "-fx-border-color: #D8BB93; -fx-border-radius: 5; -fx-background-color:  #D8BB93;";
            panel.getChildren().clear(); // Elimina todos los elementos de la tabla
            int referencia = 45;
            int rLineaY = 4;
            int rRutaY = 30;

            while (rs.next()) {
                Label linea = new Label("Línea " + rs.getString("id"));
                linea.setLayoutX(120);
                linea.setLayoutY(rLineaY);
                linea.setStyle("-fx-font-size: 16;");
                linea.setPrefHeight(25);
                linea.setPrefWidth(80);
                linea.setAlignment(Pos.CENTER);
                String origen = rs.getNString("ciudadOrigen");
                String destino = rs.getString("ciudadDestino");
                Label ruta = new Label(origen + " - " + destino);
                ruta.setLayoutX(85);
                ruta.setLayoutY(rRutaY);
                ruta.setPrefHeight(17);
                ruta.setPrefWidth(150);
                ruta.setAlignment(Pos.CENTER);

                Pane p = new Pane();
                Image img = null;
                ImageView imgView = null;
                String tipo = rs.getString("tipo");
                if (tipo.equalsIgnoreCase("tren")) {
                    img = new Image(getClass().getResourceAsStream("fotos/entrenar.png"));
                    imgView = new ImageView(img);
                } else if (tipo.equalsIgnoreCase("bus")) {
                    img = new Image(getClass().getResourceAsStream("fotos/autobus.png"));
                    imgView = new ImageView(img);
                } else {
                    img = new Image(getClass().getResourceAsStream("fotos/metro.png"));
                    imgView = new ImageView(img);
                }
                p.setStyle(BORDER_STYLE);
                p.setPrefWidth(320);
                p.setPrefHeight(60);
                p.setLayoutX(34);
                p.setLayoutY(referencia);
                p.getChildren().add(linea);
                p.getChildren().add(ruta);
                p.getChildren().add(imgView);

                panel.setPrefHeight(referencia + 66);
                panel.getChildren().add(p);

                referencia += 66;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
