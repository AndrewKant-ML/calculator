package it.ispw22.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField output;
    private Double first;
    private Double second;
    private Double result = 0.0;

    private Operation operation;

    private int ignoreInputSize = 0;

    public void sum() {
        result = first + second;
    }

    public void sub() {
        result = first - second;
    }

    public void mul() {
        result = first * second;
    }

    public void div() throws ArithmeticException {
        if (Double.compare(second, 0.0) != 0)
            result = first / second;
        else
            throw new ArithmeticException("Division by zero");
    }

    public void sqrt() throws ArithmeticException {
        if (Double.compare(first, 0) >= 0)
            result = Math.sqrt(first);
        else
            throw new ArithmeticException("Square root of a negative number");
    }

    @FXML
    protected void write(ActionEvent event) {
        output.setText(output.getText().concat(((Button) event.getSource()).getText()));
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
        second = 0.0;
    }

    @FXML
    protected void sub(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.SUB;
        second = 0.0;
    }

    @FXML
    protected void mul(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.MUL;
        second = 1.0;
    }

    @FXML
    protected void div(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operation = Operation.DIV;
        second = 1.0;
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
        switch (operation) { // TD check overflow, max insertable digits
            case SUM:
                sum();
                break;
            case SUB:
                sub();
                break;
            case MUL:
                mul();
                break; // Not overflow
            case DIV:
                try {
                    div();
                } catch (ArithmeticException e) {
                    output.setText(e.getMessage());
                }
                break;
            case SQRT: // TD write sqrt before number
                try {
                    sqrt();
                } catch (ArithmeticException e) {
                    output.setText(e.getMessage());
                }
                break;
        }
        output.setText(String.valueOf(result));
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Double getResult() {
        return result;
    }
}
