package cide.proyectofinal;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RecuperarUsuarioController {
    // Credenciales de correo electrónico para enviar el mensaje
    private static final String REMITENTE = "Ivantiz45@gmail.com";
    private static final String CLAVE_EMAIL = "mjbmyjyjyeyezciu";

    // Campo de texto para introducir el correo electrónico
    @FXML
    private TextField txtCorreoElectronico;

    public static String correoElectronico = "";

    public void verificarCorreo(ActionEvent event) throws Exception {
        // Consulta para obtener la información del usuario a partir de su correo
        // electrónico
        String query = "select * from " + App.bbdd + ".usuarios where correo_electronico = '"
                + txtCorreoElectronico.getText() + "'";

        // Asunto y cuerpo del mensaje de correo electrónico
        String asunto = "Modificar nombre del usuario";
        String cuerpo = "Enviariamos un link con la pantalla de modificar el nombre del usuario";

        try (Statement sentencia = App.conexion.createStatement()) {
            ResultSet rs = sentencia.executeQuery(query);
            if (rs.next()) {
                // Si se encuentra el usuario, se almacena su correo electrónico y se envía el
                // mensaje
                correoElectronico = rs.getString("correo_electronico");
                App.setRoot("modificarUsuario");
                enviarCorreo(correoElectronico, asunto, cuerpo);
                System.out.println("Correo enviado");
            } else {
                // Si no se encuentra el usuario, se muestra una alerta de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al verificar el correo electrónico");
                alert.setHeaderText(null);
                alert.setContentText("El correo electrónico no se encuentra registrado.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            // Si ocurre un error al ejecutar la consulta, se muestra una alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al verificar el correo electrónico");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo verificar el correo electrónico. Por favor, inténtalo de nuevo.");
            alert.showAndWait();
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) throws Exception {
        // Configuración de las propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        // Creación de la sesión de correo electrónico
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            // Configuración del mensaje de correo electrónico
            message.setFrom(new InternetAddress(REMITENTE));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            try (Transport transport = session.getTransport("smtp")) {
                // Conexión al servidor SMTP y envío del mensaje
                transport.connect("smtp.gmail.com", REMITENTE, CLAVE_EMAIL);
                transport.sendMessage(message, message.getAllRecipients());
            }
        } catch (MessagingException me) {
            // Si ocurre un error al enviar el mensaje, se muestra una alerta y se lanza una
            // excepción
            System.out.println("Error al enviar el correo electrónico: " + me.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al enviar correo electrónico");
            alert.setHeaderText("No se pudo enviar el correo electrónico.");
            alert.setContentText("Por favor, revisa tu conexión a internet y vuelve a intentarlo más tarde.");
            alert.showAndWait();
            throw new Exception("Error al enviar el correo electrónico.");
        }
    }
    public void irLogin() throws IOException {
        App.setRoot("login");
        
    }

}
