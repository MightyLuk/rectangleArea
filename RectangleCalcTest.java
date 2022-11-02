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
    void testCalcRectangleValid() throws LengthNegativeException, ResultTooLargeException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 2.5;
        double b = 0.85;        
        double actual = 0;
        try {
            actual = rectangleCalc.calcRectangle(a, b);
        } catch (LengthNegativeException e){
            e.printStackTrace();
        } catch (ResultTooLargeException e){
            e.printStackTrace();
        }        
        assertEquals(2.125, actual);
    }
    @Test
    void testCalcRectangLengthNegative() throws LengthNegativeException, ResultTooLargeException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = -2.5;
        double b = 0.85;
              
        try {
            double actual = rectangleCalc.calcRectangle(a, b);
            fail();
        } catch (LengthNegativeException e){
            assertEquals("Eingabe ungültig, bitte geben Sie keine negativen Zahlen ein.", e.getMessage());
        } catch (ResultTooLargeException e){
            e.printStackTrace();
            fail();
        }        
    
    }
    @Test
    void testCalcRectangResultTooLarge() throws LengthNegativeException, ResultTooLargeException{
        RectangleCalc rectangleCalc = new RectangleCalc();
        double a = 9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.9 ;
        double b = 9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.9 ;        
        try {
            double actual = rectangleCalc.calcRectangle(a, b);
            fail();
        } catch (LengthNegativeException e){
            e.printStackTrace();
            fail();
        } catch (ResultTooLargeException e){
            assertEquals("Das Ergebnis ist zu groß!", e.getMessage());
        }        
        
    }

    
}
