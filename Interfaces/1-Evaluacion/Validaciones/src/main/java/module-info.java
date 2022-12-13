module dam.interfaces.validaciones {
    requires javafx.controls;
    requires javafx.fxml;


    opens dam.interfaces.validaciones to javafx.fxml;
    exports dam.interfaces.validaciones;
}