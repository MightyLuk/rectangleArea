import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleCalcTest {

    @Test
    void testGetDoubleFromStringValid() {
        RectangleCalc rectangleCalc = new RectangleCalc();
        String input = "1.5";
        double expected = 1.5;
        double actual = rectangleCalc.getDoubleFromString(input);

        assertEquals(expected, actual);
    }
    @Test
    void testGetDoubleFromStringException() throws NumberFormatException{
        assertThrows(NumberFormatException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                RectangleCalc rectangleCalc = new RectangleCalc();
                rectangleCalc.getDoubleFromString("einspunktfünf");                
            }            
        });        
    }

    @Test
    void testCalcRectangleValid1() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 0;
        double b = 1;        
        double actual = 1; // nicht 0 da 0 der erwartete Wert ist
        try {
            actual = rectangleCalc.calcRectangle(a, b);
        } catch (LengthNegativeException e){
            e.printStackTrace();
        } catch (LengthTooLongException e){
            e.printStackTrace();
        }        
        assertEquals(0, actual);
    }
    @Test
    void testCalcRectangleValid2() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 1.5;
        double b = 2.1234;        
        double actual = 0;
        try {
            actual = rectangleCalc.calcRectangle(a, b);
        } catch (LengthNegativeException e){
            e.printStackTrace();
        } catch (LengthTooLongException e){
            e.printStackTrace();
        }        
        assertEquals(3.1851, actual);
    }
    @Test
    void testCalcRectangleValid3() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 1000000;
        double b = 1.234;        
        double actual = 0;
        try {
            actual = rectangleCalc.calcRectangle(a, b);
        } catch (LengthNegativeException e){
            e.printStackTrace();
        } catch (LengthTooLongException e){
            e.printStackTrace();
        }        
        assertEquals(1234000, actual);
    }
    @Test
    void testCalcRectangleValid4() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 1;
        double b = 1.12345;        
        double actual = 0;
        try {
            actual = rectangleCalc.calcRectangle(a, b);
        } catch (LengthNegativeException e){
            e.printStackTrace();
        } catch (LengthTooLongException e){
            e.printStackTrace();
        }        
        assertEquals(1.1235, actual);
    }

    @Test
    void testCalcRectangLengthNegative() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = -2.5;
        double b = 0.85;
              
        try {
            double actual = rectangleCalc.calcRectangle(a, b);
            fail();
        } catch (LengthNegativeException e){
            assertEquals("Eingabe ungültig, bitte geben Sie keine negativen Zahlen ein.", e.getMessage());
        } catch (LengthTooLongException e){
            e.printStackTrace();
            fail();
        }        
    
    }
    @Test
    void testCalcRectangResultTooLarge() throws LengthNegativeException, LengthTooLongException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 2.5;
        double b = 1000000.01;        
        try {
            double actual = rectangleCalc.calcRectangle(a, b);
            fail();
        } catch (LengthNegativeException e){
            e.printStackTrace();
            fail();
        } catch (LengthTooLongException e){
            assertEquals("Eingabe ungültig, bitte geben Sie keine Zahlen größer als 1000000 ein.", e.getMessage());
        }        
        
    }

    
}
