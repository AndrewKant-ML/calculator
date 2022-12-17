package it.ispw22.calculator.control;

import it.ispw22.calculator.Operation;
import it.ispw22.calculator.bean.ControllerBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GraphicController {

    private Double first;
    private Double second;
    private Double result = 0.0;
    private Operation operation;
    @FXML
    private TextField output;

    private final ControllerBean bean = new ControllerBean();
    private final ApplicationController applicationController = new ApplicationController(bean);
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
        bean.setFirst(first);
        bean.setSecond(second);
        bean.setOperation(operation);
        applicationController.operate();
        if (bean.getException() == null) {
            result = bean.getResult();
            output.setText(String.valueOf(result));
        } else {
            output.setText(bean.getException().getMessage());
        }
    }

    public ControllerBean getBean() {
        return bean;
    }

    public ApplicationController getApplicationController() {
        return applicationController;
    }
}
