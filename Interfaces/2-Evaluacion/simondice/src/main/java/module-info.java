module cide.interfaces {
    requires javafx.controls;
    requires javafx.fxml;

    opens cide.interfaces to javafx.fxml;
    exports cide.interfaces;
}
