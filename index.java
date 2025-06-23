import java.util.Scanner;

public class index {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String studentId;

        while (true) {
            System.out.print("กรุณาใส่รหัสนักศึกษา 10 หลัก: ");
            studentId = scanner.nextLine();

            if (studentId.length() == 10) {
                System.out.println("รหัสนักศึกษาถูกต้อง");
                break;
            } else {
                System.out.println("โปรดลองใส่อีกครั้ง");
            }
        }

        scanner.close();
    }

}
