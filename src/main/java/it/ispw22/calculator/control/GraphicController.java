package it.ispw22.calculator.control;

import it.ispw22.calculator.Operator;
import it.ispw22.calculator.bean.*;
import it.ispw22.calculator.exception.OperationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GraphicController {

    private Double first;
    private Double second;
    private Operator operator;
    @FXML
    private TextField output;

    private final ApplicationController applicationController = new ApplicationController();
    private int ignoreInputSize = 0;

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
        operator = Operator.SUM;
        second = 0.0;
    }

    @FXML
    protected void sub(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operator = Operator.SUB;
        second = 0.0;
    }

    @FXML
    protected void mul(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operator = Operator.MUL;
        second = 1.0;
    }

    @FXML
    protected void div(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operator = Operator.DIV;
        second = 1.0;
    }

    @FXML
    protected void sqrt(ActionEvent event) {
        first = Double.parseDouble(output.getText());
        write(event);
        ignoreInputSize = output.getText().length();
        operator = Operator.SQRT;
    }

    @FXML
    protected void resolve() {
        if (output.getText().length() > ignoreInputSize)
            second = Double.parseDouble(output.getText().substring(ignoreInputSize));
        OperandBean operandBean = new OperandBean(first);
        OperandBean secondBean = new OperandBean(second);
        OperatorBean operatorBean = new OperatorBean(operator);
        ResultBean resultBean = new ResultBean();
        try {
            applicationController.operate(operandBean, secondBean, operatorBean, resultBean);
            output.setText(String.valueOf(resultBean.getResult()));
        } catch (OperationException e) {
            output.setText(e.getMessage());
        }
    }

    public ApplicationController getApplicationController() {
        return applicationController;
    }
}
