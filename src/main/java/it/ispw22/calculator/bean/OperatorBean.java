package it.ispw22.calculator.bean;

import it.ispw22.calculator.Operator;

public class OperatorBean {

    private final Operator operator;

    public OperatorBean(Operator operator) {
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }
}
