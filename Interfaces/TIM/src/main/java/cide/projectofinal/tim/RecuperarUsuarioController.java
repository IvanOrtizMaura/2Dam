package cide.projectofinal.tim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecuperarUsuarioController {
@FXML
private TextField txtCorreoElectronico;
    public void verificarCorreo(ActionEvent event) {
        Statement sentencia = null;
        String query = "select correElectronico from " + App.bbdd + ".usaurios where correElectronico = '"+ txtCorreoElectronico.getText() + "'";
        try{
            sentencia = App.conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            if (rs.next()){
                System.out.println(rs.getString("correoElectronico"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
