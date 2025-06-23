import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BankAccountApp extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn;
    private JPanel loginPanel;
    private JPanel accountPanel;

    public BankAccountApp() {
        setTitle("Bank Account");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setupLoginPanel();
    }

    private void setupLoginPanel() {
        getContentPane().removeAll();

        Color bgColor = new Color(135, 206, 250); // ฟ้าอ่อน
        Color inputBgColor = Color.WHITE;
        Color btnColor = Color.WHITE;
        Color btnTextColor = new Color(70, 70, 70);

        getContentPane().setBackground(bgColor);

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(bgColor);
        loginPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        JLabel icon = new JLabel(new ImageIcon("profile.png"));
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(icon);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel title = new JLabel("BANK LOGIN");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(title);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setMaximumSize(new Dimension(280, 40));
        userPanel.setBackground(inputBgColor);
        userPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel userIcon = new JLabel(new ImageIcon("user.png"));
        userPanel.add(userIcon, BorderLayout.WEST);
        userField = new JTextField("Username");
        userField.setForeground(Color.GRAY);
        userField.setBorder(null);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userPanel.add(userField, BorderLayout.CENTER);
        loginPanel.add(userPanel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        userField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (userField.getText().equals("Username")) {
                    userField.setText("");
                    userField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (userField.getText().isEmpty()) {
                    userField.setText("Username");
                    userField.setForeground(Color.GRAY);
                }
            }
        });

        JPanel passPanel = new JPanel(new BorderLayout());
        passPanel.setMaximumSize(new Dimension(280, 40));
        passPanel.setBackground(inputBgColor);
        passPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel passIcon = new JLabel(new ImageIcon("lock.png"));
        passPanel.add(passIcon, BorderLayout.WEST);
        passField = new JPasswordField("Password");
        passField.setForeground(Color.GRAY);
        passField.setBorder(null);
        passField.setEchoChar((char) 0);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passPanel.add(passField, BorderLayout.CENTER);
        loginPanel.add(passPanel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        passField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                String passText = new String(passField.getPassword());
                if (passText.equals("Password")) {
                    passField.setText("");
                    passField.setForeground(Color.BLACK);
                    passField.setEchoChar('•');
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (passField.getPassword().length == 0) {
                    passField.setText("Password");
                    passField.setForeground(Color.GRAY);
                    passField.setEchoChar((char) 0);
                }
            }
        });

        // Remember Me และ Forgot Password
        JPanel optionsPanel = new JPanel(new BorderLayout());
        optionsPanel.setBackground(bgColor);
        optionsPanel.setMaximumSize(new Dimension(280, 30));

        JCheckBox remember = new JCheckBox("Remember me");
        remember.setBackground(bgColor);
        remember.setForeground(Color.WHITE);
        optionsPanel.add(remember, BorderLayout.WEST);

        JLabel forgot = new JLabel("<html><u>Forgot Password?</u></html>");
        forgot.setForeground(new Color(70, 70, 70));
        optionsPanel.add(forgot, BorderLayout.EAST);

        loginPanel.add(optionsPanel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        // ปุ่ม Login
        loginBtn = new JButton("LOGIN");
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginBtn.setBackground(btnColor);
        loginBtn.setForeground(btnTextColor);
        loginBtn.setFocusPainted(false);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.setMaximumSize(new Dimension(280, 40));
        loginBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        loginPanel.add(loginBtn);

        loginBtn.addActionListener(e -> handleLogin());

        add(loginPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
        setTitle("Bank Account");
    }

    private void handleLogin() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (username.equals("Kittiphat") && password.equals("121314")) {
            showAccountInfo();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAccountInfo() {
        getContentPane().removeAll();
        setTitle("Account Details");

        Color bgColor = new Color(135, 206, 250);
        getContentPane().setBackground(bgColor);

        accountPanel = new JPanel();
        accountPanel.setLayout(new BoxLayout(accountPanel, BoxLayout.Y_AXIS));
        accountPanel.setBackground(bgColor);
        accountPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 16));
        area.setBackground(bgColor);
        area.setForeground(Color.BLACK);
        area.setText("Account Information\n");
        area.append("-----------------------------\n");
        area.append("Name      : Kittiphat Phengnamkham\n");
        area.append("Account ID: 6752300704\n");
        area.append("Balance   : 350,000.00 Bath\n");
        area.append("ET    : Computer Engineering and \n        Artificial Intelligence \n");

        area.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBorder(null);

        accountPanel.add(scroll);
        accountPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        logoutBtn.setMaximumSize(new Dimension(120, 35));
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutBtn.addActionListener(e -> setupLoginPanel());

        accountPanel.add(logoutBtn);

        add(accountPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAccountApp().setVisible(true));
    }
}
