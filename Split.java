import java.util.Scanner;

public class Split {

    public static String removeDashes(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return phoneNumber.replace("-", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String input1 = scanner.nextLine();

        System.out.println("Input: " + input1 + " -> Output: " + removeDashes(input1));

        scanner.close();
    }
}
