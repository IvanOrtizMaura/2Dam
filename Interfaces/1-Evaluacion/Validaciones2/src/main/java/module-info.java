module cide.interfaces.validaciones2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cide.interfaces.validaciones2 to javafx.fxml;
    exports cide.interfaces.validaciones2;
}