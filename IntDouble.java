import java.util.Scanner;

public class IntDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int a = scanner.nextInt();

        System.out.print("Enter a decimal number: ");
        double b = scanner.nextDouble();

        if (a > b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
}