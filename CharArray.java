import java.util.Scanner;

public class CharArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        printCharsNoSpace(input);
        scanner.close();
    }

    public static void printCharsNoSpace(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c != ' ') {
                System.out.println(c);
            }
        }
    }
}

/*
 * Flowchart Description:
 * 
 * Start
 * |
 * v
 * Input string (user input)
 * |
 * v
 * Convert string to char array using toCharArray()
 * |
 * v
 * For each character in char array:
 * |-- Is character a space?
 * | \
 * | No --> Print character
 * |
 * Yes
 * |
 * v
 * Skip printing
 * |
 * v
 * End loop
 * |
 * v
 * End
 */
