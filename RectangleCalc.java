public class RectangleCalc {
    public double getDoubleFromString(String text){
        double temp = -1;

        try{
            temp = Double.parseDouble(text);
        } catch (Exception e){
            throw new NumberFormatException("Eingabe ungültig, bitte geben Sie Zahlen im Intervall [0, ∞].");
        }
        if(temp < 0){
            throw new NumberFormatException("Eingabe ungültig, bitte geben Sie Zahlen im Intervall [0, ∞].");
        }
        return temp;
    }

    public double calcRectangle(double a, double b){
        double area = a*b;
        return area;
    }
    
}
