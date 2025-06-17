package frames;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    // Atribut Warna
    private Color DARK_GREYISH_BLUE = new Color(56, 73, 89);
    private Color CADET_BLUE = new Color(159, 191, 222);
    private Color SOFT_BLUE = new Color(189, 221, 252);

    // Atribut font
    private Font LABEL = new Font("Calibri", Font.PLAIN, 20);
    private Font ALERT = new Font("Century Gothic", Font.BOLD, 18);

    public MainFrame() {
        this.setTitle("Perpustakaan");
        this.setSize(900,520);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null); // Layar ditengah
        this.setVisible(true); // Agar terlihat

        // Panel utama
        JPanel Panel = new JPanel(new GridLayout(5, 1, 0, 10));
        Panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        Panel.setBackground(DARK_GREYISH_BLUE);

        JLabel User_Label = new JLabel("Username:");
        User_Label.setForeground(Color.WHITE);
        User_Label.setFont(LABEL);
        RoundTextField User_Field = new RoundTextField(100);

        JLabel Password_Label = new JLabel("Password:");
        Password_Label.setForeground(Color.WHITE);
        Password_Label.setFont(LABEL);
        RoundPasswordField Password_Field = new RoundPasswordField(100);

        JLabel Alert_Message = new JLabel("");
        Alert_Message.setForeground(Color.RED);
        Alert_Message.setFont(ALERT);

        // Tombol
        RoundButton loginButton = new RoundButton("Login", CADET_BLUE, SOFT_BLUE);

        // Tambahkan komponen ke Panel
        Panel.add(User_Label);
        Panel.add(User_Field);
        Panel.add(Password_Label);
        Panel.add(Password_Field);
        Panel.add(loginButton);

        this.add(Panel, BorderLayout.CENTER);
        this.add(Alert_Message, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String username = User_Field.getText();
            String password = new String(Password_Field.getPassword());

            if (username.equals("admin") && password.equals("adminlogin")) {
                Alert_Message.setText("Login berhasil!");
                EventQueue.invokeLater(AdminFrame :: new);
                dispose();
            } else {
                Alert_Message.setText("Username atau password salah.");
            }
        });
    }
}
