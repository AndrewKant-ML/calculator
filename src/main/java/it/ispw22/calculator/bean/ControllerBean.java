package it.ispw22.calculator.bean;

import it.ispw22.calculator.Operation;

public class ControllerBean {

    private Double first;
    private Double second;
    private Double result = 0.0;
    private Operation operation;

    private ArithmeticException exception;

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(ArithmeticException exception) {
        this.exception = exception;
    }
}
