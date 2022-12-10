package it.ispw22.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField output;
    private double first, second;
    private Operation operation;

    private int ignoreInputSize = 0;

    private double sum(double first, double second) {
        return first + second;
    }

    private double sub(double first, double second) {
        return first - second;
    }

    private double mul(double first, double second) {
        return first * second;
    }

    private double div(double first, double second) throws ArithmeticException {
        if (Double.compare(first, second) == 0)
            return first / second;
        throw new ArithmeticException("Division by zero");
    }

    private double sqrt(double num) throws ArithmeticException {
        if (Double.compare(num, 0) >= 0)
            return Math.sqrt(num);
        throw new ArithmeticException("Square root of a negative number");
    }

    @FXML
    protected void write(ActionEvent event) {
        output.setText(output.getText().concat(((Button)event.getSource()).getText()));
    }

    @FXML
    protected void cancel() {
        if (output.getText().length() > 0) {
            output.setText(output.getText(0, output.getText().length() - 1));
            if (ignoreInputSize > 0)
                ignoreInputSize--;
        }
    }

    @FXML
    protected void delete() {
        output.setText("");
        ignoreInputSize = 0;
    }

    @FXML
    protected void sum(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.SUM;
        second = 0;
    }

    @FXML
    protected void sub(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.SUB;
        second = 0;
    }

    @FXML
    protected void mul(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.MUL;
        second = 1;
    }

    @FXML
    protected void div(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.DIV;
        second = 1;
    }

    @FXML
    protected void sqrt(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.SQRT;
    }

    @FXML
    protected void resolve() {
        if (output.getText().length() > ignoreInputSize)
            second = Double.parseDouble(output.getText().substring(ignoreInputSize));
        switch (operation) {
            case SUM: output.setText(String.valueOf(sum(first, second))); break;
            case SUB: output.setText(String.valueOf(sub(first, second))); break;
            case MUL: output.setText(String.valueOf(mul(first, second))); break;
            case DIV:
                try {
                    output.setText(String.valueOf(div(first, second)));
                } catch (ArithmeticException e) {
                    output.setText(e.getMessage());
                }
                break;
            case SQRT:
                try {
                    output.setText(String.valueOf(sqrt(first)));
                } catch (ArithmeticException e) {
                    output.setText(e.getMessage());
                }
                break;
        }
    }
}
