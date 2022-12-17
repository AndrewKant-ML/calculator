package test;

import it.ispw22.calculator.Operation;
import it.ispw22.calculator.control.GraphicController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class ControllerTest {

    @Test
    public void testSum() {
        GraphicController graphicController = new GraphicController();
        graphicController.getBean().setFirst(4.0);
        graphicController.getBean().setSecond(5.0);
        graphicController.getBean().setOperation(Operation.SUM);
        graphicController.getApplicationController().operate();
        Assertions.assertEquals(graphicController.getBean().getResult(), 9.0, 0);
    }
    @Test
    public void testSub() {
        GraphicController graphicController = new GraphicController();
        graphicController.getBean().setFirst(4.0);
        graphicController.getBean().setSecond(5.0);
        graphicController.getBean().setOperation(Operation.SUB);
        graphicController.getApplicationController().operate();
        Assertions.assertEquals(graphicController.getBean().getResult(), -1.0, 0);
    }
    @Test
    public void testMul() {
        GraphicController graphicController = new GraphicController();
        graphicController.getBean().setFirst(4.0);
        graphicController.getBean().setSecond(5.0);
        graphicController.getBean().setOperation(Operation.MUL);
        graphicController.getApplicationController().operate();
        Assertions.assertEquals(graphicController.getBean().getResult(), 20.0, 0);
    }
    @Test
    public void testDiv() {
        GraphicController graphicController = new GraphicController();
        graphicController.getBean().setFirst(4.0);
        graphicController.getBean().setSecond(5.0);
        graphicController.getBean().setOperation(Operation.DIV);
        graphicController.getApplicationController().operate();
        Assertions.assertEquals(graphicController.getBean().getResult(), 0.8, 0);
    }

    @Test
    public void testSqrt() {
        GraphicController graphicController = new GraphicController();
        graphicController.getBean().setFirst(4.0);
        graphicController.getBean().setOperation(Operation.SQRT);
        graphicController.getApplicationController().operate();
        Assertions.assertEquals(graphicController.getBean().getResult(), 2.0, 0);
    }
}
