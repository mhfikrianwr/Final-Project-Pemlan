package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.time.LocalDate;

public class MainFrame extends JFrame {
    // Atribut Warna
    private Color DARK_GREYISH_BLUE = new Color(56, 73, 89);
    private Color CADET_BLUE = new Color(159, 191, 222);
    private Color SOFT_BLUE = new Color(189, 221, 252);

    // Atribut font
    private Font TITLE_LABEL = new Font("Calibri", Font.BOLD, 30);
    private Font LABEL = new Font("Calibri", Font.PLAIN, 20);
    private Font ALERT = new Font("Century Gothic", Font.BOLD, 18);

    public MainFrame() {
        this.setTitle("Perpustakaan");
        this.setSize(900, 520);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null); // Layar ditengah
        this.setVisible(true); // Agar terlihat

        // Panel utama
        JPanel panel = new JPanel(new GridLayout(6, 1, 0, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel.setBackground(DARK_GREYISH_BLUE);

        // Set Tanggal
        LocalDate tanggal = LocalDate.of(2025, 06, 18);
        JLabel tanggalLabel = new JLabel(tanggal.toString());
        tanggalLabel.setBackground(DARK_GREYISH_BLUE);
        tanggalLabel.setFont(TITLE_LABEL);
        tanggalLabel.setForeground(Color.WHITE); // Set warna teks agar terlihat

        // Panel untuk tanggal
        JPanel tanggalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tanggalPanel.setBackground(DARK_GREYISH_BLUE);
        tanggalPanel.add(tanggalLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(LABEL);
        RoundTextField userField = new RoundTextField(100);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(LABEL);
        RoundPasswordField passwordField = new RoundPasswordField(100);

        JLabel alertMessage = new JLabel("");
        alertMessage.setForeground(Color.RED);
        alertMessage.setFont(ALERT);

        // Tombol
        RoundButton loginButton = new RoundButton("Login", CADET_BLUE, SOFT_BLUE);

        // Tambahkan komponen ke Panel
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        this.add(tanggalPanel, BorderLayout.NORTH); // Tambahkan panel tanggal
        this.add(panel, BorderLayout.CENTER);
        this.add(alertMessage, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("adminlogin")) {
                alertMessage.setText("Login berhasil!");
                EventQueue.invokeLater(AdminFrame::new);
                dispose();
            } else {
                alertMessage.setText("Username atau password salah.");
            }
        });
    }
}
