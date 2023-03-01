package cide.projectofinal.tim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginContraseñaController implements Initializable {
    @FXML
    private TextField txtContrasena;
    @FXML
    private  Label lblBienvenido;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String bienvenido = lblBienvenido.getText() + LoginController.usuario;
        lblBienvenido.setText(bienvenido);
    }

    public void verificarContraseña(ActionEvent event) {
        System.out.println("aadshf");
        Statement sentencia;
        String query = "select contraseña from " + App.bbdd + ".usuarios where nombreUsuario= '" + LoginController.usuario + "' and contraseña= '" + txtContrasena.getText() + "'";
        try{
            System.out.println("sdfd");
            sentencia = App.conexion.createStatement();
            System.out.println("sdfd");
            ResultSet rs = sentencia.executeQuery(query);
            if (rs.next()){
                System.out.println(rs.getString("contraseña"));
                modoHome(event);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void modoHome(ActionEvent event) {
        Ventana.cerrarVentanaActual(event);
        Ventana.abrirVentana("inicio");
    }
}
