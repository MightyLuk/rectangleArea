import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die erste Variable ein!");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Bitte geben Sie die zweite Variable ein!");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Die Fläche beträgt: " + a * b);
    }
}