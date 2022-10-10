import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die erste Variable ein!");
        String textA = sc.nextLine();
        System.out.println("Bitte geben Sie die zweite Variable ein!");
        String textB = sc.nextLine();

        RectangleCalc ractangleCalc = new RectangleCalc();
        try{
            double a = ractangleCalc.getDoubleFromString(textA);
            double b = ractangleCalc.getDoubleFromString(textB);
            double area = ractangleCalc.calcRectangle(a, b);
            System.out.printf("Die Fläche des Rechtecks beträgt: %f", area);
        } catch (Exception e){
            System.out.println("Es ist ein Fehler aufgetreten");
            System.out.println(e.getMessage()); 
        }
    }
}