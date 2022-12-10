module it.ispw22.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.ispw22.calculator to javafx.fxml;
    exports it.ispw22.calculator;
}