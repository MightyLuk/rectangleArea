public class RectangleCalc {
    public double getDoubleFromString(String text) throws NumberFormatException{
        double temp = -1;

        try{
            temp = Double.parseDouble(text);
        } catch (Exception e){
            throw new NumberFormatException("Eingabe ungültig, bitte geben Sie Zahlen im Intervall [0, unendlich].");
        }       
        return temp;
    }

    public double calcRectangle(double a, double b) throws LengthNegativeException, ResultTooLargeException{
        if (a < 0 || b < 0){
            throw new LengthNegativeException("Eingabe ungültig, bitte geben Sie keine negativen Zahlen ein.");
        }

        double area = a*b;
        if(Double.isInfinite(area)){
            throw new ResultTooLargeException("Das Ergebnis ist zu groß!");
        }
        return area;
    }
    
}
