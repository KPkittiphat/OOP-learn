import java.util.Scanner;

public class StringFormatter {

    public static String formatString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        input = input.trim();

        String[] words = input.split("\\s+");
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {

                formatted.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    formatted.append(words[i].substring(1).toLowerCase());
                }
                if (i < words.length - 1) {
                    formatted.append(" ");
                }
            }
        }
        return formatted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String output = formatString(input);
        System.out.println("Formatted : " + output);
        scanner.close();
    }
}
