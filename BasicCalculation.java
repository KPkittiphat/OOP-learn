import java.util.Scanner;

public class BasicCalculation {
    public static void main(String[] args) {
        System.out.print("Enter you num : ");
        Scanner sc = new Scanner(System.in);

        double n = sc.nextDouble();

        String op = sc.next();

        double m = sc.nextDouble();

        double result = 0;

        switch (op) {
            case "+":
                result = n + m;
                break;
            case "-":
                result = n - m;
                break;
            case "*":
                result = n * m;
                break;
            case "/":

                if (m != 0) {
                    result = n / m;
                } else {
                    System.out.println("Error: Division by zero");
                    sc.close();
                    return;
                }
                break;
            case "^":
                result = Math.pow(n, m);
                break;
            default:
                System.out.println("Invalid operator");
                sc.close();
                return;
        }

        if (result == (int) result) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}
