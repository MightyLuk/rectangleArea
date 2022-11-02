import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die erste Seitenlänge ein!");
        String textA = sc.nextLine();
        System.out.println("Bitte geben Sie die zweite Seitenlänge ein!");
        String textB = sc.nextLine();

        RectangleCalc rectangleCalc = new RectangleCalc();
        try{
            double a = rectangleCalc.getDoubleFromString(textA);
            double b = rectangleCalc.getDoubleFromString(textB);
            double area = rectangleCalc.calcRectangle(a, b);
            System.out.printf("Die Fläche des Rechtecks beträgt: %f", area);
        } catch (Exception e){
            System.out.println("Es ist ein Fehler aufgetreten");
            System.out.println(e.getMessage()); 
        }
    }
}