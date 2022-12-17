module it.ispw22.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.ispw22.calculator to javafx.fxml;
    exports it.ispw22.calculator;
    exports it.ispw22.calculator.control;
    exports it.ispw22.calculator.bean;
    opens it.ispw22.calculator.control to javafx.fxml;
}