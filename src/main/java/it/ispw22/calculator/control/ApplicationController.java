package it.ispw22.calculator.control;

import it.ispw22.calculator.Operation;
import it.ispw22.calculator.bean.ControllerBean;

public class ApplicationController {

    private final ControllerBean bean;

    public ApplicationController(ControllerBean bean) {
        this.bean = bean;
    }

    public void sum() {
        bean.setResult(bean.getFirst() + bean.getSecond());
    }

    public void sub() {
        bean.setResult(bean.getFirst() - bean.getSecond());
    }

    public void mul() {
        bean.setResult(bean.getFirst() * bean.getSecond());
    }

    public void div() throws ArithmeticException {
        if (Double.compare(bean.getSecond(), 0.0) != 0)
            bean.setResult(bean.getFirst() / bean.getSecond());
        else
            throw new ArithmeticException("Division by zero");
    }

    public void sqrt() throws ArithmeticException {
        if (Double.compare(bean.getFirst(), 0) >= 0)
            bean.setResult(Math.sqrt(bean.getFirst()));
        else
            throw new ArithmeticException("Square root of a negative number");
    }

    public void operate() {
        bean.setException(null);
        switch (bean.getOperation()) { // TD check overflow, max insertable digits
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
                    bean.setException(e);
                }
                break;
            case SQRT: // TD write sqrt before number
                try {
                    sqrt();
                } catch (ArithmeticException e) {
                    bean.setException(e);
                }
                break;
        }
    }
}
