package test;

import it.ispw22.calculator.CalculatorController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class ControllerTest {

    @Test
    public void testSum() {
        CalculatorController application = new CalculatorController();
        application.setFirst(4.0);
        application.setSecond(5.0);
        application.sum();
        Assertions.assertEquals(application.getResult(), 9.0, 0);
    }
    @Test
    public void testSub() {
        CalculatorController application = new CalculatorController();
        application.setFirst(4.0);
        application.setSecond(5.0);
        application.sub();
        Assertions.assertEquals(application.getResult(), -1, 0);
    }
    @Test
    public void testMul() {
        CalculatorController application = new CalculatorController();
        application.setFirst(4.0);
        application.setSecond(5.0);
        application.mul();
        Assertions.assertEquals(application.getResult(), 20.0, 0);
    }
    @Test
    public void testDiv() {
        CalculatorController application = new CalculatorController();
        application.setFirst(4.0);
        application.setSecond(5.0);
        application.div();
        Assertions.assertEquals(application.getResult(), 0.8, 0);
    }

    @Test
    public void testSqrt() {
        CalculatorController application = new CalculatorController();
        application.setFirst(4.0);
        application.sqrt();
        Assertions.assertEquals(application.getResult(), 2.0, 0);
    }
}
