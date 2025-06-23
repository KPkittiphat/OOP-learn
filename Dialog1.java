
import javax.swing.JOptionPane;

public class Dialog1 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hi what's your name? ");
        String name = JOptionPane.showInputDialog("Enter your name :");
        String message = String.format("Welcome %s to Java Programming ", name);
        JOptionPane.showMessageDialog(null, message);
    }
}
