module cide.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;

    opens cide.proyectofinal to javafx.fxml;
    exports cide.proyectofinal;
}
