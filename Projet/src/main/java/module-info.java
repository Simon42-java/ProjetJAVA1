module javafxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens javafxml to javafx.fxml;

    exports javafxml;
}