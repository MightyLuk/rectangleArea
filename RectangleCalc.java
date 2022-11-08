public class RectangleCalc {
    public double getDoubleFromString(String text) throws NumberFormatException{
        double temp = -1;

        try{
            temp = Double.parseDouble(text);
        } catch (Exception e){
            throw new NumberFormatException("Eingabe ungültig, bitte geben Sie Zahlen im Intervall [0, 1000000].");
        }       
        return temp;
    }

    public double calcRectangle(double a, double b) throws LengthNegativeException, LengthTooLongException{
        if (a < 0 || b < 0){
            throw new LengthNegativeException("Eingabe ungültig, bitte geben Sie keine negativen Zahlen ein.");
        }
        if (a > 1000000 || b > 100000){
            throw new LengthTooLongException("Eingabe ungültig, bitte geben Sie keine Zahlen größer als 1000000 ein."); 
        }

        double area = a*b;
        area = Math.round(area*10000.0)/10000.0;
        
        return area;
    }
    
}
