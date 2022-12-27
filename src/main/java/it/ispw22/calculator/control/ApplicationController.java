package it.ispw22.calculator.control;

import it.ispw22.calculator.bean.OperandBean;
import it.ispw22.calculator.bean.OperatorBean;
import it.ispw22.calculator.bean.ResultBean;

public class ApplicationController {

    public void sum(OperandBean firstOperand, OperandBean secondOperand, ResultBean resultBean) {
        resultBean.setResult(firstOperand.getValue() + secondOperand.getValue());
    }

    public void sub(OperandBean firstOperand, OperandBean secondOperand, ResultBean resultBean) {
        resultBean.setResult(firstOperand.getValue() - secondOperand.getValue());
    }

    public void mul(OperandBean firstOperand, OperandBean secondOperand, ResultBean resultBean) {
        resultBean.setResult(firstOperand.getValue() * secondOperand.getValue());
    }

    public void div(OperandBean firstOperand, OperandBean secondOperand, ResultBean resultBean) throws ArithmeticException {
        if (Double.compare(firstOperand.getValue(), 0.0) != 0)
            resultBean.setResult(firstOperand.getValue() / secondOperand.getValue());
        else
            throw new ArithmeticException("Division by zero");
    }

    public void sqrt(OperandBean operand, ResultBean resultBean) throws ArithmeticException {
        if (Double.compare(operand.getValue(), 0.0) >= 0)
            resultBean.setResult(Math.sqrt(operand.getValue()));
        else
            throw new ArithmeticException("Square root of a negative number");
    }

    public void operate(OperandBean firstOperand, OperandBean secondOperand, OperatorBean operatorBean, ResultBean resultBean) throws Exception {
        switch (operatorBean.getOperator()) { // TD check overflow, max insertable digits
            case SUM:
                sum(firstOperand, secondOperand, resultBean);
                break;
            case SUB:
                sub(firstOperand, secondOperand, resultBean);
                break;
            case MUL:
                mul(firstOperand, secondOperand, resultBean);
                break;
            case DIV:
                try {
                    div(firstOperand, secondOperand, resultBean);
                } catch (ArithmeticException e) {
                    throw new Exception("Division error", e.getCause());
                }
                break;
            case SQRT: // TD write sqrt before number
                try {
                    sqrt(firstOperand, resultBean);
                } catch (ArithmeticException e) {
                    throw new Exception("Square root error", e.getCause());
                }
                break;
        }
    }
}
