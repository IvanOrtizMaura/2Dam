package cide.projectofinal.tim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class LoginController {
    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnSiguiente;
    public static String usuario = "";

    public void verificarUsuario(ActionEvent event) {
        Statement sentencia = null;
        String query  = "select nombreUsuario from " + App.bbdd + ".usuarios where nombreUsuario = '"+ txtUsuario.getText() + "'";

        try{
            sentencia = App.conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            if (rs.next()) {
                usuario = rs.getString("nombreUsuario");
                System.out.println(usuario);
                modoContraseña(event);
            } else {System.out.println("Usuario incorrecto");

            } ;
            rs.close();

        } catch (SQLException e) {
            System.err.println("Error al crear la sentencia");
            throw new RuntimeException(e);
        }
    }

    public void modoContraseña(ActionEvent e){
        Ventana.cerrarVentanaActual(e);
        Ventana.abrirVentana("loginContraseña");
    }
}