module cide.projectofinal.tim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens cide.projectofinal.tim to javafx.fxml;
    exports cide.projectofinal.tim;
}