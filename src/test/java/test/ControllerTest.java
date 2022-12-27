package test;

import it.ispw22.calculator.Operator;
import it.ispw22.calculator.bean.OperandBean;
import it.ispw22.calculator.bean.OperatorBean;
import it.ispw22.calculator.bean.ResultBean;
import it.ispw22.calculator.control.GraphicController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ControllerTest {

    @Test
    public void testSum() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperandBean secondBean = new OperandBean(5.0);
        OperatorBean operatorBean = new OperatorBean(Operator.SUM);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, secondBean, operatorBean, resultBean);
            Assertions.assertEquals(resultBean.getResult(), 9.0, 0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    @Test
    public void testSub() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperandBean secondBean = new OperandBean(5.0);
        OperatorBean operatorBean = new OperatorBean(Operator.SUB);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, secondBean, operatorBean, resultBean);
            Assertions.assertEquals(resultBean.getResult(), -1.0, 0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    @Test
    public void testMul() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperandBean secondBean = new OperandBean(5.0);
        OperatorBean operatorBean = new OperatorBean(Operator.MUL);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, secondBean, operatorBean, resultBean);
            Assertions.assertEquals(resultBean.getResult(), 20.0, 0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    @Test
    public void testDiv() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperandBean secondBean = new OperandBean(5.0);
        OperatorBean operatorBean = new OperatorBean(Operator.DIV);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, secondBean, operatorBean, resultBean);
            Assertions.assertEquals(resultBean.getResult(), 0.8, 0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testDivByZero() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperandBean secondBean = new OperandBean(0.0);
        OperatorBean operatorBean = new OperatorBean(Operator.DIV);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, secondBean, operatorBean, resultBean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testSqrt() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(4.0);
        OperatorBean operatorBean = new OperatorBean(Operator.SQRT);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, new OperandBean(0.0), operatorBean, resultBean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testSqrtOfNegNumber() {
        GraphicController graphicController = new GraphicController();
        OperandBean firstBean = new OperandBean(-1.0);
        OperatorBean operatorBean = new OperatorBean(Operator.SQRT);
        ResultBean resultBean = new ResultBean();
        try {
            graphicController.getApplicationController().operate(firstBean, new OperandBean(0.0), operatorBean, resultBean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
