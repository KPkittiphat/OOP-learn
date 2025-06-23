import java.util.Scanner;

public class Username {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("โปรดกรอก Username เพื่อทำการสมัครบริการ : ");
        String username1 = input.nextLine();
        System.out.print("โปรดกรอก Username อีกครั้ง เพื่อทำการสมัครบริการ : ");
        String username2 = input.nextLine();

        if (username1.equals(username2)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed! Please re-enter again!");
        }

        input.close();
    }
}
